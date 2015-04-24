package org.simbiosis.systemui.api.bean;

import org.simbiosis.systemui.api.dto.SessionDto;
import org.simbiosis.systemui.api.dto.SimpleSessionDto;

public interface IUISessionManager {

	SimpleSessionDto login(String userName, String password);

	String logout(String sessionName);

	SimpleSessionDto isValid(String sessionName);

	SessionDto getLoginInfo(String sessionName, String moduleName);
}
