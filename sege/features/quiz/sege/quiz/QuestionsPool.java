package sege.quiz;

import java.util.ArrayList;
import java.util.Random;

import sege.quiz.Question;

/**
 * TODO description
 */
public class QuestionsPool {

	Random random = new Random();
	ArrayList<Question> pool = new ArrayList<Question>();
	
	public QuestionsPool() {
		this.initPool();
	}
	
	public void initPool() {
		// Extension point
	}

	private void addQuestion(String question, String answer, String ... others) {
		this.pool.add(new Question(question, answer, others));
	}
	
	public Question getRandomQuestion() {
		int index = random.nextInt(this.pool.size());
		Question q = this.pool.remove(index);
		return q;
	}

}