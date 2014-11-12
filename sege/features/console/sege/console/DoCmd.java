package sege.console;

import sege.GameException;
import sege.GameService;

public class DoCmd extends Cmd {

	public DoCmd(String gameId, String playerId, String actionId) {
		super(gameId, playerId, actionId);
	}

	String exec(GameService service) throws GameException {
		return service.doAction(this.gameId, this.playerId, this.actionId);
	}

}
