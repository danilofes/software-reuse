package sege;

import java.util.List;
import java.util.ArrayList;

/**
 * Base abstract class to help to implement a GameInstance.
 */
public abstract class BaseGameInstance implements GameInstance {

	protected String status;
	private String roomId;
	private List players;

	protected static final String OPEN = "open";
	protected static final String STARTED = "started";
	protected static final String FINISHED = "finished";

	protected static final String ACTION_START = "start";

	public BaseGameInstance(String roomId) {
		this.status = OPEN;
		this.roomId = roomId;
		this.players = new ArrayList();
	}

	public GameInstanceInfo getInfo() {
		return new GameInstanceInfo(this.roomId, this.status, this.players.size());
	}

	public boolean join(String playerId) {
		if (this.status == OPEN && !this.players.contains(playerId)) {
			this.players.add(playerId);
			return true;
		}
		return false;
	}

	public void leave(String playerId) throws GameException {
		if (this.players.contains(playerId)) {
			this.players.remove(playerId);
			if (this.players.isEmpty()) {
				this.status = OPEN;
			}
		} else {
			throw new GameException(String.format("Player %s is not in room %s.", playerId, roomId));
		}
	}

	public GameState getStatus(final String playerId) {
		if (this.status == OPEN) {
			return new BaseGameState(playerId, this.status, new String[]{ACTION_START});
		} else if (this.status == STARTED) {
			return getStateWhenStarted(playerId);
		} else {
			return new BaseGameState(playerId, this.status, new String[]{});
		}
	}

	public GameState doAction(String playerId, String actionId) {
		if (this.status == OPEN) {
			if (actionId.equals(ACTION_START)) {
				this.status = STARTED;
				this.startNewGame();
				return getStateWhenStarted(playerId);
			}
		} else if (this.status == STARTED) {
			List possibleActions = new ArrayList(); 
			this.collectActionsForPlayer(playerId, possibleActions);
			if (possibleActions.contains(actionId)) {
				this.doValidAction(playerId, actionId);
				return getStateWhenStarted(playerId);
			}
		}
		throw new RuntimeException("Invalid action: " + actionId);
	}

	protected void collectActionsForPlayer(String playerId, List list) {
		//
	}

	protected abstract void doValidAction(String playerId, String actionId);

	protected abstract void startNewGame();

	protected abstract GameState getStateWhenStarted(String playerId);
}
