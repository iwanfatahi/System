package org.simbiosis.system.api.bean;

import org.simbiosis.system.model.Session;

public interface ISessionManager {
	String getSalt();

	String login(String userName, String password);

	long logout(String sessionName);

	Boolean isValid(String sessionName);
	
	Session getSession(String sessionName);
}
