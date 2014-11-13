package sege.console;

import sege.GameException;
import sege.GameService;

public class JoinCmd extends Cmd {

	public JoinCmd(String gameId, String playerId) {
		super(gameId, playerId, null);
	}
	
	String exec(GameService service) throws GameException {
		return service.joinGame(this.gameId, this.playerId);
	}

}
