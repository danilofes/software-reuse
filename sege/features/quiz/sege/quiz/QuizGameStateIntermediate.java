package sege.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.JsonObject;

import sege.InternalGameState;
import sege.quiz.Question;

public class QuizGameStateIntermediate extends QuizGameState {

	private static final int LAST_ROUND = 8;
	private int currentPlayer;
	private int currentRound;
	private Question currentQuestion;
	
	public QuizGameStateIntermediate(QuestionsPool pool, String[] players, int[] scores, int currentRound, int currentPlayer, Question currentQuestion) {
		super(pool, players, scores);
		this.currentRound = currentRound;
		this.currentPlayer = currentPlayer;
		this.currentQuestion = currentQuestion;
	}

	public JsonObject getExternalRepresentation(String playerId) {
		JsonObject stateObj = super.getExternalRepresentation(playerId);
		
		stateObj.addProperty("currentRound", currentRound);
		stateObj.addProperty("currentPlayer", players[currentPlayer]);
		stateObj.addProperty("question", currentQuestion.getDescription());
		
		JsonObject optionsObj = new JsonObject();
		List<String> options = currentQuestion.getOptions();
		for (int i = 0; i < options.size(); i++) {
			optionsObj.addProperty("" + (i + 1), options.get(i));
		}
		stateObj.add("options", optionsObj);
		return stateObj;
	}

	public List<String> getActions(String playerId) {
		if (players[currentPlayer].equals(playerId)) {
			List<String> options = currentQuestion.getOptions();
			List<String> optionIds = new ArrayList<String>(options.size());
			for (int i = 0; i < options.size(); i++) {
				optionIds.add("" + (i + 1));
			}
			return optionIds;
		}
		return Collections.emptyList();
	}

	public InternalGameState applyAction(String playerId, String actionId) {
		int option = Integer.valueOf(actionId);
		if (this.currentQuestion.isCorrect(option - 1)) {
			this.incrementScore(this.currentPlayer);
		}
		
		if (currentRound == LAST_ROUND && currentPlayer == (players.length - 1)) {
			return new QuizGameStateFinal(pool, players, scores);
		}
		
		int nextPlayer = (currentPlayer + 1) % players.length;
		int nextRound = nextPlayer == 0 ? currentRound + 1 : currentRound;
		Question nextQuestion = pool.getRandomQuestion();
		nextQuestion.shuffle();
		return new QuizGameStateIntermediate(pool, players, scores, nextRound, nextPlayer, nextQuestion);
	}

}