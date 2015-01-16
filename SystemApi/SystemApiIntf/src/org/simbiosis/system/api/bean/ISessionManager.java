package org.simbiosis.system.api.bean;

import org.simbiosis.system.api.dto.SessionDto;

public interface ISessionManager {
	String getSalt();

	String login(String userName, String password);

	SessionDto loginWithMenu(String userName, String password, String salt);

	void logout(String sessionName);

	Boolean isValid(String sessionName);
}
