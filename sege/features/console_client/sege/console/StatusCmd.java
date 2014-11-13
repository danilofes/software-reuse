package sege.console;

import sege.GameException;
import sege.GameService;

public class StatusCmd extends Cmd {

	public StatusCmd(String gameId, String playerId) {
		super(gameId, playerId, null);
	}

	String exec(GameService service) throws GameException {
		return service.gameStatus(this.gameId, this.playerId);
	}

}
