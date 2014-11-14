package sege;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import sege.GameRoom;

/**
 * Default GameService implementation.
 */
public class GameServiceImpl implements GameService {

	protected Map<String, GameRoom> games = new LinkedHashMap<String, GameRoom>();
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public static GameService create() {
		GameServiceImpl service = new GameServiceImpl();
		service.initGames();
		return service;
	}

	private void initGames() {
		try {
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("games.xml");
			try {
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document document = db.parse(in);
				
				NodeList nodes =  document.getElementsByTagName("game");
				for (int i = 0; i < nodes.getLength(); i++) {
					 Node node = nodes.item(i);
					 NamedNodeMap attributes = node.getAttributes();
					 String id = attributes.getNamedItem("id").getNodeValue();
					 String className = attributes.getNamedItem("gameClass").getNodeValue();
					 Class<? extends GamePlugin> pluginClass = (Class<? extends GamePlugin>) Class.forName(className);
					 this.games.put(id, new GameRoom(id, pluginClass.newInstance()));
				}
			} finally {
				in.close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public synchronized String listGames() {
		Collection<GameRoom> gs = this.games.values();
		JsonArray array = new JsonArray();
		for (GameRoom gi : gs) {
			JsonObject obj = new JsonObject();
			obj.addProperty("gameId", gi.getId());
			obj.addProperty("status", gi.getStatus());
			obj.addProperty("numberOfPlayers", gi.getNumberOfPlayers());
			array.add(obj);
		}
		JsonObject response = new JsonObject();
		response.add("games", array);
		return gson.toJson(response);
	}

	public synchronized String joinGame(String gameId, String playerId) throws GameException {
		GameRoom gi = this.get(gameId);
		gi.join(playerId);
		return gson.toJson(gi.getState(playerId));
	}

	public synchronized String leaveGame(String gameId, String playerId) throws GameException {
		GameRoom gi = this.get(gameId);
		gi.leave(playerId);
		return this.listGames();
	}

	public synchronized String startGame(String gameId, String playerId) throws GameException {
		GameRoom gi = this.get(gameId);
		gi.start(playerId);
		return gson.toJson(gi.getState(playerId));
	}

	public synchronized String gameState(String gameId, String playerId) throws GameException {
		return gson.toJson(this.get(gameId).getState(playerId));
	}

	public synchronized String doAction(String gameId, String playerId, String actionId) throws GameException {
		GameRoom gi = this.get(gameId);
		gi.applyAction(playerId, actionId);
		return gson.toJson(gi.getState(playerId));
	}

	private GameRoom get(String gameId) throws GameException {
		GameRoom gi = this.games.get(gameId);
		if (gi == null) {
			throw new GameException(String.format("Game not found: %s", gameId));
		}
		return gi;
	}
}
