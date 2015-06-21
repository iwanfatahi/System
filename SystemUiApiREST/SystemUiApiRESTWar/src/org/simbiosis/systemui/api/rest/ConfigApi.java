package org.simbiosis.systemui.api.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.simbiosis.systemui.api.bean.IConfigManager;
import org.simbiosis.systemui.api.dto.UiConfigDto;

@Path("/config")
public class ConfigApi {

	@EJB(lookup = "java:global/SystemUiApi/SystemUiApiEjb/ConfigManager")
	IConfigManager configManager;

	@GET()
	@Path("/")
	@Produces("application/json")
	public UiConfigDto getConfig() {
		return configManager.getConfig();
	}
}
