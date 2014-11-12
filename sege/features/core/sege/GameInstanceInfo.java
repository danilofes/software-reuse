package sege;

/**
 * Represents general info about a game instance (room), so that a palyer may decide to join.
 */
public final class GameInstanceInfo {
	private String gameId;
	private String gameStatus;
	private int numberOfPlayers;
	
	public GameInstanceInfo(String gameId, String gameStatus, int numberOfPlayers) {
		this.gameId = gameId;
		this.gameStatus = gameStatus;
		this.numberOfPlayers = numberOfPlayers;
	}
	
	public String getGameId() {
		return this.gameId;
	}

	public String getGameStatus() {
		return this.gameStatus;
	}

	public int getNumberOfPlayers() {
		return this.numberOfPlayers;
	}
}