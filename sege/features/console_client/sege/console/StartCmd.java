package sege.console;

import sege.GameException;
import sege.GameService;

public class StartCmd extends Cmd {

	public StartCmd(String gameId, String playerId) {
		super(gameId, playerId, null);
	}
	
	String exec(GameService service) throws GameException {
		return service.startGame(this.gameId, this.playerId);
	}

}
