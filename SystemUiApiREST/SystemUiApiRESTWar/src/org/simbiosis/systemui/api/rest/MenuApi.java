package org.simbiosis.systemui.api.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.simbiosis.systemui.api.bean.IMenuManager;
import org.simbiosis.systemui.api.dto.MenuDto;

@Path("/menu")
public class MenuApi {

	@EJB(lookup = "java:global/SystemUiApi/SystemUiApiEjb/MenuManager")
	IMenuManager menuManager;

	@GET()
	@Path("/listbycompany/{sessionName}")
	@Produces("application/json")
	public List<MenuDto> listMenuByCompany(
			@PathParam("sessionName") String sessionName) {
		return menuManager.listMenuByCompany(sessionName);
	}
}
