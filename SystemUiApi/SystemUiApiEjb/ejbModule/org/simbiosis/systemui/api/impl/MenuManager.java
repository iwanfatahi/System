package org.simbiosis.systemui.api.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.simbiosis.system.bean.ISecurity;
import org.simbiosis.system.model.Session;
import org.simbiosis.systemui.api.bean.IMenuManager;
import org.simbiosis.systemui.api.dto.MenuDto;
import org.simbiosis.systemui.bean.IMenu;
import org.simbiosis.systemui.model.Menu;

@Stateless
@Remote(IMenuManager.class)
public class MenuManager implements IMenuManager {

	@EJB(lookup = "java:global/System/SystemEjb/SecurityImpl")
	ISecurity iSecurity;
	@EJB(lookup = "java:global/SystemUi/SystemUiEjb/MenuImpl")
	IMenu iMenu;

	@Override
	public List<MenuDto> listMenuByCompany(String sessionName) {
		// Find session for this sessionName
		Session session = iSecurity.getSession(sessionName);
		// If found -> logged in
		if (session != null) {
			List<MenuDto> result = new ArrayList<MenuDto>();
			List<Menu> menus = iMenu.listMenuByCompany(session.getUser()
					.getCompany().getId());
			for (Menu menu : menus) {
				MenuDto dto = new MenuDto();
				dto.setId(menu.getId());
				dto.setTitle(menu.getTitle());
				Menu parent = menu.getParent();
				if (parent != null) {
					dto.setParentTitle(parent.getTitle());
					Menu grandParent = parent.getParent();
					if (grandParent != null) {
						dto.setGrandParentTitle(grandParent.getTitle());
					}
				}
				result.add(dto);
			}
			return result;
		}
		return new ArrayList<MenuDto>();
	}
}
