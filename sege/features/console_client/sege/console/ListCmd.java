package sege.console;

import sege.GameService;

public class ListCmd extends Cmd {

	public ListCmd() {
		super(null, null, null);
	}

	String exec(GameService service) {
		return service.listGames();
	}

}
