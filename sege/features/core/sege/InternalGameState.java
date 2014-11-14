package sege;

import java.util.List;

import com.google.gson.JsonElement;

public interface InternalGameState {

	JsonElement getExternalRepresentation(String playerId);

	List<String> getActions(String playerId);

	InternalGameState applyAction(String playerId, String actionId);

}