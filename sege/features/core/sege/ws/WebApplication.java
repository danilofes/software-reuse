package sege.ws;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.core.Application;

public class WebApplication extends Application {

	private RestGameService restService = new RestGameService();
	
	@Override
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(restService);
	}
}