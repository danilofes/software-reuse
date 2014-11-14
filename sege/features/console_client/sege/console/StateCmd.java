package sege.console;

import sege.GameException;
import sege.GameService;

public class StateCmd extends Cmd {

	public StateCmd(String gameId, String playerId) {
		super(gameId, playerId, null);
	}
	
	String exec(GameService service) throws GameException {
		return service.gameState(this.gameId, this.playerId);
	}

}
