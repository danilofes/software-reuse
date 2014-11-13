package sege.console;

import sege.GameException;
import sege.GameService;

public class LeaveCmd extends Cmd {

	public LeaveCmd(String gameId, String playerId) {
		super(gameId, playerId, null);
	}

	String exec(GameService service) throws GameException {
		return service.leaveGame(this.gameId, this.playerId);
	}

}
