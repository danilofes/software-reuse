package sege.quiz;

import sege.InternalGameState;

import java.util.Arrays;

import com.google.gson.JsonObject;


public abstract class QuizGameState implements InternalGameState {

	protected QuestionsPool pool;
	protected String[] players;
	protected int[] scores;

	public QuizGameState(QuestionsPool pool, String[] players, int[] scores) {
		this.pool = pool;
		this.players = Arrays.copyOf(players, players.length);
		this.scores = Arrays.copyOf(scores, players.length);
	}

	public JsonObject getExternalRepresentation(String playerId) {
		JsonObject scoreObj = new JsonObject();
		for (int i = 0; i < this.players.length; i++) {
			scoreObj.addProperty(this.players[i], this.scores[i]);
		}
		JsonObject stateObj = new JsonObject();
		stateObj.add("score", scoreObj);
		return stateObj;
	}

	public void incrementScore(int player) {
		this.scores[player]++;
	}
}
