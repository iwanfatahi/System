package org.simbiosis.systemui.api.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.simbiosis.systemui.api.bean.IUISessionManager;
import org.simbiosis.systemui.api.dto.SessionDto;

@Path("/session")
public class SessionUiApi {

	@EJB(lookup = "java:global/SystemUiApi/SystemUiApiEjb/UISessionManager")
	IUISessionManager sessionManager;

	@GET()
	@Path("/isvalid/{sessionName}")
	@Produces("text/plain")
	public String isValid(@PathParam("sessionName") String sessionName) {
		return sessionManager.isValid(sessionName) ? "1" : "0";
	}

	@GET()
	@Path("/getlogininfo/{sessionName}/{moduleName}")
	@Produces("application/json")
	public SessionDto getLoginInfo(
			@PathParam("sessionName") String sessionName,
			@PathParam("moduleName") String moduleName) {
		return sessionManager.getLoginInfo(sessionName, moduleName);
	}
}
