package sege;

import sege.quiz.QuizGameInstance;

public class GameServiceImpl {

	protected void initGames() {
		original();
		this.addGame(new QuizGameInstance("quiz"));
	}

}
