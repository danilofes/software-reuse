package sege.simules;

import java.util.Collections;
import java.util.List;

import com.google.gson.JsonObject;

import sege.InternalGameState;

public class SimulEsGameState implements InternalGameState {

	public JsonObject getExternalRepresentation(String playerId) {
		JsonObject stateObj = new JsonObject();
		// TODO
		return stateObj;
	}
	
	public List<String> getActions(String playerId) {
		// TODO
		return Collections.emptyList();
	}

	public InternalGameState applyAction(String playerId, String actionId) {
		// TODO
		return this;
	}

}