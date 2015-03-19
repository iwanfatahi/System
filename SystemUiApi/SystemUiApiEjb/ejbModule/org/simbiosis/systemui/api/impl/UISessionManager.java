package org.simbiosis.systemui.api.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.simbiosis.system.api.bean.ISessionManager;
import org.simbiosis.system.bean.ISecurity;
import org.simbiosis.system.bean.IUser;
import org.simbiosis.system.model.Session;
import org.simbiosis.system.model.User;
import org.simbiosis.systemui.api.bean.IUISessionManager;
import org.simbiosis.systemui.api.dto.MenuDto;
import org.simbiosis.systemui.api.dto.SessionDto;
import org.simbiosis.systemui.api.dto.SimpleSessionDto;
import org.simbiosis.systemui.bean.IMenu;
import org.simbiosis.systemui.model.Menu;

@Stateless
@Remote(IUISessionManager.class)
public class UISessionManager implements IUISessionManager {

	@EJB(lookup = "java:global/System/SystemEjb/SecurityImpl")
	ISecurity iSecurity;
	@EJB(lookup = "java:global/System/SystemEjb/UserImpl")
	IUser iUser;
	@EJB(lookup = "java:global/SystemApi/SystemApiEjb/SessionManager")
	ISessionManager iSessionManager;
	@EJB(lookup = "java:global/SystemUi/SystemUiEjb/MenuImpl")
	IMenu iMenu;

	@Override
	public SimpleSessionDto isValid(String sessionName) {
		SimpleSessionDto result = new SimpleSessionDto();
		Session session = iSecurity.getSession(sessionName);
		if (session != null) {
			result.setName(session.getName());
			result.setFirstModule(session.getUser().getFirstModule());
		}
		return result;
	}

	@Override
	public SessionDto getLoginInfo(String sessionName, String moduleName) {
		Session session = iSecurity.getSession(sessionName);
		if (session != null) {
			SessionDto dto = new SessionDto();
			dto.setSessionName(sessionName);
			User user = session.getUser();
			dto.setUserName(user.getName());
			dto.setUserRealName(user.getRealName());
			dto.setCompanyName(user.getCompany().getName());
			dto.setBranchName(user.getBranch().getName());
			// Ambil menu
			List<Menu> menus = iMenu.listMenuByRoleModule(user.getRole()
					.getId(), moduleName);
			for (Menu menu : menus) {
				MenuDto mdto = new MenuDto();
				mdto.setId(menu.getId());
				mdto.setTitle(menu.getTitle());
				mdto.setIcon(menu.getIcon());
				mdto.setLink(menu.getPlace());
				Menu parent = menu.getParent();
				if (parent != null) {
					mdto.setParentTitle(parent.getTitle());
					Menu grandParent = parent.getParent();
					if (grandParent != null) {
						mdto.setGrandParentTitle(grandParent.getTitle());
					}
				}
				dto.getMenuItems().add(mdto);
			}
			return dto;
		}
		return null;
	}

	@Override
	public SimpleSessionDto login(String userName, String password) {
		SimpleSessionDto result = new SimpleSessionDto();
		result.setName(iSessionManager.login(userName, password));
		if (!result.getName().isEmpty()) {
			Session session = iSecurity.getSession(result.getName());
			result.setFirstModule(session.getUser().getFirstModule());
			return result;
		}
		return null;
	}

}
