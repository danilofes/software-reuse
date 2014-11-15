package sege;

import java.util.ArrayList;
import java.util.List;

import sege.InternalGameState;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class GameRoom {
	
	public void start(String playerId) throws GameException {
		if (this.players.size() < plugin.getMinPlayers()) {
			throw new GameException(String.format("Need %d players to start the game", plugin.getMinPlayers()));
		}
		original(playerId);
	}

}