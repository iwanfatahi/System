package org.simbiosis.systemui.api.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class SystemUiApiRest extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	public SystemUiApiRest() {
		classes.add(SessionUiApi.class);
		classes.add(MenuApi.class);
		classes.add(ConfigApi.class);
		// singletons.add(new SessionApi());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
