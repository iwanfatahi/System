package org.simbiosis.system.api.rest;

import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.simbiosis.system.api.bean.ISessionManager;

@Path("/session")
public class SessionApi {

	@EJB(lookup = "java:global/SystemApi/SystemApiEjb/SessionManager")
	ISessionManager sessionManager;

	@GET()
	@Path("/salt")
	@Produces("text/plain")
	public String getSalt() {
		return sessionManager.getSalt();
	}

	@POST()
	@Path("/login")
	@Produces("text/plain")
	public String login(@FormParam("userName") String userName,
			@FormParam("password") String password) {
		return sessionManager.login(userName, password);
	}

	@GET()
	@Path("/logout/{sessionName}")
	@Produces("text/plain")
	public String logout(@PathParam("sessionName") String sessionName) {
		sessionManager.logout(sessionName);
		return "0";
	}

}
