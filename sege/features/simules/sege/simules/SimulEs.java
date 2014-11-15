package sege.simules;

import java.util.List;

import sege.GamePlugin;
import sege.InternalGameState;

public class SimulEs implements GamePlugin {

	public InternalGameState createInitialState(List<String> players) {
		return new SimulEsGameState();
	}

	public int getMinPlayers() {
		return 1;
	}
	
	public int getMaxPlayers() {
		return Integer.MAX_VALUE;
	}
}