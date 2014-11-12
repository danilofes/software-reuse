package sege;

public interface GameState {

	final String OPEN = "open";
	final String STARTED = "started";
	final String FINISHED = "finished";

	String getPlayerId();

	String getStatus();
	
	String[] getActions();

}
