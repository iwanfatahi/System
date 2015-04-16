package org.simbiosis.system.api.bean;

public interface ISessionManager {
	String getSalt();

	String login(String userName, String password);

	void logout(String sessionName);

	Boolean isValid(String sessionName);
}
