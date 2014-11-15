package sege;

import java.util.ArrayList;
import java.util.List;

import sege.InternalGameState;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class GameRoom {
	
	public void join(String playerId) throws GameException {
		if (this.players.size() >= plugin.getMaxPlayers()) {
			throw new GameException(String.format("Cannot join game: room is full"));
		}
		original(playerId);
	}
}