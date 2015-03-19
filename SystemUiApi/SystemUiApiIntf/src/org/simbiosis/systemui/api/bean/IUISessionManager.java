package org.simbiosis.systemui.api.bean;

import org.simbiosis.systemui.api.dto.SimpleSessionDto;
import org.simbiosis.systemui.api.dto.SessionDto;

public interface IUISessionManager {

	SimpleSessionDto login(String userName, String password);

	SimpleSessionDto isValid(String sessionName);

	SessionDto getLoginInfo(String sessionName, String moduleName);
}
