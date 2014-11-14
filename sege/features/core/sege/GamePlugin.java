package sege;

import java.util.List;


public interface GamePlugin {

	InternalGameState createInitialState(List<String> players);

}