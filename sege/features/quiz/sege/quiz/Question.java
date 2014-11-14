package sege.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * TODO description
 */
public final class Question {

	private String description;
	private String answer;
	private ArrayList<String> options;

	public Question(String description, String answer, String ... others) {
		this.description = description;
		this.answer = answer;
		this.options = new ArrayList<String>(others.length + 1);
		this.options.add(answer);
		for (String other : others) {
			this.options.add(other);
		}
		this.shuffle();
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public List<String> getOptions() {
		return this.options;
	}
	
	public boolean isCorrect(int answer) {
		return this.answer.equals(this.options.get(answer));
	}

	public void shuffle() {
		Collections.shuffle(this.options);
	}
	
}