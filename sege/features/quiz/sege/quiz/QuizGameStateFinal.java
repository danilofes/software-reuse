package sege.quiz;

import java.util.Collections;
import java.util.List;

import sege.InternalGameState;

public class QuizGameStateFinal extends QuizGameState {

	public QuizGameStateFinal(QuestionsPool pool, String[] players, int[] scores) {
		super(pool, players, scores);
	}

	public List<String> getActions(String playerId) {
		return Collections.emptyList();
	}

	public InternalGameState applyAction(String playerId, String actionId) {
		return this;
	}
}