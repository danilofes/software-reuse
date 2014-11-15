package sege.quiz;

import java.util.List;

import sege.GamePlugin;
import sege.InternalGameState;
import sege.quiz.Question;
import sege.quiz.QuestionsPool;

public class Quiz implements GamePlugin {

	public InternalGameState createInitialState(List<String> players) {
		QuestionsPool pool = new QuestionsPool();
		String[] playersArray = new String[players.size()];
		int[] score = new int[players.size()];
		for (int i = 0; i < players.size(); i++) {
			playersArray[i] = players.get(i);
			score[i] = 0;
		}
		Question question = pool.getRandomQuestion();
		question.shuffle();
		return new QuizGameStateIntermediate(pool, playersArray, score, 1, 0, question);
	}

	public int getMinPlayers() {
		return 1;
	}
	
	public int getMaxPlayers() {
		return Integer.MAX_VALUE;
	}

}
