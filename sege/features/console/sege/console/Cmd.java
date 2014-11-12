package sege.console;

import sege.GameException;
import sege.GameService;

abstract class Cmd {
	
	protected String gameId;
	protected String playerId;
	protected String actionId;
	
	public Cmd(String gameId, String playerId, String actionId) {
		this.gameId = gameId;
		this.playerId = playerId;
		this.actionId = actionId;
	}
	
	abstract String exec(GameService service) throws GameException;
	
	boolean isExit() {
		return false;
	}
}
