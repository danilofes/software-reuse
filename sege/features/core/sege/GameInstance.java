package sege;

/**
 * Represents an instance of a particular game and provides the operations to play it.
 */
public interface GameInstance {

	GameInstanceInfo getInfo();
	
	boolean join(String playerId) throws GameException;

	void leave(String playerId) throws GameException;
	
	GameState getStatus(String playerId) throws GameException;
	
	GameState doAction(String playerId, String actionId) throws GameException;

}