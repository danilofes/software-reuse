package sege.quiz;

import sege.GameState;
import java.util.List;
import sege.BaseGameInstance;

/**
 * TODO description
 */
public class QuizGameInstance extends BaseGameInstance {

	public QuizGameInstance(String roomId) {
		super(roomId);
	}
	
	protected void getActionsForPlayer(String playerId, List actions) {
		//
	}

	protected void doValidAction(String playerId, String actionId) {
		//
	}

	protected void startNewGame() {
		//
	}

	protected GameState getStateWhenStarted(String playerId) {
		return new QuizGameState(playerId, this.status, new String[]{});
	}

}
