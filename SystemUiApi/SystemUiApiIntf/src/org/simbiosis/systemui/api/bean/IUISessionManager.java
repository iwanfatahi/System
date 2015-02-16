package org.simbiosis.systemui.api.bean;

import org.simbiosis.systemui.api.dto.SessionDto;

public interface IUISessionManager {

	Boolean isValid(String sessionName);

	SessionDto getLoginInfo(String sessionName, String moduleName);
}
