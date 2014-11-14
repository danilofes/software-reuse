package sege;

import java.util.ArrayList;
import java.util.List;

import sege.InternalGameState;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class GameRoom {

	private String gameId;
	private GamePlugin plugin;
	private String status;
	private List<String> players;
	private InternalGameState internalState;

	protected static final String OPEN = "open";
	protected static final String STARTED = "started";

	public GameRoom(String gameId, GamePlugin plugin) {
		this.gameId = gameId;
		this.plugin = plugin;
		this.status = OPEN;
		this.players = new ArrayList<String>();
	}
	
	public String getId() {
		return this.gameId;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public int getNumberOfPlayers() {
		return this.players.size();
	}
	
	public JsonObject getState(String playerId) throws GameException {
		JsonObject object = new JsonObject();
		object.addProperty("gameId", this.gameId);
		object.addProperty("status", this.status);
		if (this.status == STARTED) {
			object.add("state", this.internalState.getExternalRepresentation(playerId));
			List<String> actions = this.internalState.getActions(playerId);
			JsonArray array = new JsonArray();
			for (String action : actions) {
				array.add(new JsonPrimitive(action));
			}
			object.add("actions", array);
		} else {
			JsonArray array = new JsonArray();
			for (String player : players) {
				array.add(new JsonPrimitive(player));
			}
			object.add("players", array);
		}
		return object;
	}
	
	public void join(String playerId) throws GameException {
		if (this.status == OPEN && !this.players.contains(playerId)) {
			this.players.add(playerId);
		} else {
			throw new GameException(String.format("Cannot join game %s.", gameId));
		}
	}
	
	public void start(String playerId) throws GameException {
		if (this.status == OPEN && this.players.contains(playerId)) {
			this.status = STARTED;
			this.internalState = this.plugin.createInitialState(players);
		} else {
			throw new GameException(String.format("Cannot start game %s.", gameId));
		}
	}

	public void leave(String playerId) throws GameException {
		if (this.players.contains(playerId)) {
			this.players.remove(playerId);
			this.status = OPEN;
			this.internalState = null;
		} else {
			throw new GameException(String.format("Player %s is not in room %s.", playerId, gameId));
		}
	}

	public void applyAction(String playerId, String actionId) throws GameException {
		if (this.status == STARTED) {
			List<String> actions = this.internalState.getActions(playerId);
			if (actions.contains(actionId)) {
				this.internalState = this.internalState.applyAction(playerId, actionId);
				return;
			}
		}
		throw new RuntimeException("Invalid action: " + actionId);
	}

}