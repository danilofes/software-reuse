package sege.ws;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import sege.GameException;
import sege.GameService;
import sege.GameServiceImpl;

@Path("/")
public class RestGameService {

	private final GameService gs = GameServiceImpl.create();
	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	@GET @Path("games")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGames() {
		return wrap(new Delegator() {
			public String delegate() throws Exception {
				return gs.listGames();
			}
		});
	}

	@GET @Path("games/{gameId}/{playerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response gameState(@PathParam("gameId") final String gameId, @PathParam("playerId") final String playerId) {
		return wrap(new Delegator() {
			public String delegate() throws Exception {
				return gs.gameState(gameId, playerId);
			}
		});
	}
	
	@PUT @Path("games/{gameId}/{playerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response joinGame(@PathParam("gameId") final String gameId, @PathParam("playerId") final String playerId) {
		return wrap(new Delegator() {
			public String delegate() throws Exception {
				return gs.joinGame(gameId, playerId);
			}
		});
	}
	
	@DELETE @Path("games/{gameId}/{playerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response leaveGame(@PathParam("gameId") final String gameId, @PathParam("playerId") final String playerId) {
		return wrap(new Delegator() {
			public String delegate() throws Exception {
				return gs.leaveGame(gameId, playerId);
			}
		});
	}

	@POST @Path("games/{gameId}/{playerId}/start")
	@Produces(MediaType.APPLICATION_JSON)
	public Response startGame(@PathParam("gameId") final String gameId, @PathParam("playerId") final String playerId) {
		return wrap(new Delegator() {
			public String delegate() throws Exception {
				return gs.startGame(gameId, playerId);
			}
		});
	}

	@POST @Path("games/{gameId}/{playerId}/do")
	@Produces(MediaType.APPLICATION_JSON)
	public Response doAction(@PathParam("gameId") final String gameId, @PathParam("playerId") final String playerId, @FormParam("action") final String actionId) {
		return wrap(new Delegator() {
			public String delegate() throws Exception {
				return gs.doAction(gameId, playerId, actionId);
			}
		});
	}
	
	private interface Delegator {
		String delegate() throws Exception;
	} 
	
	private Response wrap(Delegator delegator) {
		try {
			String response = delegator.delegate();
			return Response.status(200).entity(response).build();
		} catch (GameException  e) {
			return Response.status(400).entity(encodeError(e)).build();
		} catch (Exception e) {
			return Response.status(500).entity(encodeError(e)).build();
		}
	}
	
	private String encodeError(Exception e) {
		JsonObject obj = new JsonObject();
		obj.addProperty("error", e.getMessage());
		return gson.toJson(obj);
	}
	
}