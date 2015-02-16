package org.simbiosis.systemui.bean;

import java.util.List;

import org.simbiosis.systemui.model.Menu;

public interface IMenu {
	List<Menu> listMenuByCompany(long company);

	List<Menu> listMenuByRole(long roleId);

	List<Menu> listMenuByRoleModule(long roleId, String module);
}
