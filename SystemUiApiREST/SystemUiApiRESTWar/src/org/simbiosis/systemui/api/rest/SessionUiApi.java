package org.simbiosis.systemui.api.rest;

import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.simbiosis.systemui.api.bean.IUISessionManager;
import org.simbiosis.systemui.api.dto.SessionDto;
import org.simbiosis.systemui.api.dto.SimpleSessionDto;

@Path("/session")
public class SessionUiApi {

	@EJB(lookup = "java:global/SystemUiApi/SystemUiApiEjb/UISessionManager")
	IUISessionManager sessionManager;

	@GET()
	@Path("/isvalid/{sessionName}")
	@Produces("application/json")
	public SimpleSessionDto isValid(@PathParam("sessionName") String sessionName) {
		return sessionManager.isValid(sessionName);
	}

	@GET()
	@Path("/getlogininfo/{sessionName}/{moduleName}")
	@Produces("application/json")
	public SessionDto getLoginInfo(
			@PathParam("sessionName") String sessionName,
			@PathParam("moduleName") String moduleName) {
		return sessionManager.getLoginInfo(sessionName, moduleName);
	}

	@POST()
	@Path("/login")
	@Produces("application/json")
	public SimpleSessionDto login(@FormParam("userName") String userName,
			@FormParam("password") String password) {
		return sessionManager.login(userName, password);
	}

	@GET()
	@Path("/logout/{sessionName}")
	@Produces("text/plain")
	public String logout(@PathParam("sessionName") String sessionName) {
		return sessionManager.logout(sessionName);
	}

}
