package sege.console;

import sege.GameService;

public class InvalidCmd extends Cmd {
	
	public InvalidCmd() {
		super(null, null, null);
	}
	
	String exec(GameService service) {
		return "Invalid command.";
	}
	
}
