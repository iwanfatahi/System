package org.simbiosis.systemui.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.simbiosis.systemui.bean.IMenu;
import org.simbiosis.systemui.model.Menu;

@Stateless
@Remote(IMenu.class)
public class MenuImpl implements IMenu {

	@PersistenceContext(unitName = "SystemUiEjb", type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> listMenuByCompany(long company) {
		Query qry = em.createNamedQuery("listMenuByCompany");
		qry.setParameter("company", company);
		return qry.getResultList();
	}

	@Override
	public List<Menu> listMenuByRole(long roleId) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> listMenuByRoleModule(long role, String module) {
		Query qry = em.createNamedQuery("listMenuByRoleModule");
		qry.setParameter("role", role);
		qry.setParameter("module", module);
		return qry.getResultList();
	}

}
