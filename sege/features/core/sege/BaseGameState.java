package sege;

import com.google.gson.Gson;

public class BaseGameState implements GameState {

	private final String player;
	private final String status;
	private final String[] actions;

	public BaseGameState(String player, String status, String[] actions) {
		this.player = player;
		this.status = status;
		this.actions = actions;
	}

	public String getPlayerId() {
		return this.player;
	}

	public String getStatus() {
		return this.status;
	}

	public String[] getActions() {
		return this.actions;
	}

}