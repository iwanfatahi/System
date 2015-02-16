package org.simbiosis.systemui.api.bean;

import java.util.List;

import org.simbiosis.systemui.api.dto.MenuDto;

public interface IMenuManager {
	List<MenuDto> listMenuByCompany(String sessionName);
}
