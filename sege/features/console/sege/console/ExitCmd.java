package sege.console;

import sege.GameService;

public class ExitCmd extends Cmd {
	
	public ExitCmd() {
		super(null, null, null);
	}
	
	String exec(GameService service) {
		return "";
	}
	
	boolean isExit() {
		return true;
	}
}
