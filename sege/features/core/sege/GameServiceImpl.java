package sege;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import sege.GameInstance;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * Default GameService implementation.
 */
public class GameServiceImpl implements GameService {

	protected Map<String, GameInstance> games = new LinkedHashMap<String, GameInstance>();
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	public static GameService create() {
		GameServiceImpl service = new GameServiceImpl();
		service.initGames();
		return service;
	}
	
	protected void initGames() {
		// Extension point to initialize games
	}

	protected void addGame(GameInstance game) {
		this.games.put(game.getInfo().getGameId(), game);
	}
	
	public synchronized String listGames() {
		Collection<GameInstance> gs = this.games.values();
		List<GameInstanceInfo> infos = new ArrayList<GameInstanceInfo>(gs.size());
		for (GameInstance gi : gs) {
			infos.add(gi.getInfo());
		}
		return gson.toJson(infos, new TypeToken<List<GameInstanceInfo>>(){}.getType());
	}

	public synchronized String joinGame(String gameId, String playerId) throws GameException {
		return gson.toJson(this.get(gameId).join(playerId));
	}
	
	public synchronized String leaveGame(String gameId, String playerId) throws GameException {
		this.get(gameId).leave(playerId);
		return gson.toJson(true);
	}

	public synchronized String gameStatus(String gameId, String playerId) throws GameException {
		return gson.toJson(this.get(gameId).getStatus(playerId));
	}

	public synchronized String doAction(String gameId, String playerId, String actionId) throws GameException {
		return gson.toJson(this.get(gameId).doAction(playerId, actionId));
	}
	
	private GameInstance get(String gameId) throws GameException {
		GameInstance gi = this.games.get(gameId);
		if (gi == null) {
			throw new GameException(String.format("Game not found: %s", gameId));
		}
		return gi;
	}
}
