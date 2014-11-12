package sege;

/**
 * The Facade that centralizes the interactions with the game server.
 */
public interface GameService {

	String listGames();

	String joinGame(String gameId, String playerId) throws GameException;
	
	String leaveGame(String gameId, String playerId) throws GameException;

	String gameStatus(String gameId, String playerId) throws GameException;

	String doAction(String gameId, String playerId, String actionId) throws GameException;

}
