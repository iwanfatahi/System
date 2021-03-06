package org.simbiosis.system.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.simbiosis.system.bean.IUser;
import org.simbiosis.system.model.Role;
import org.simbiosis.system.model.User;

@Stateless
@Remote(IUser.class)
public class UserImpl implements IUser {

	@PersistenceContext(unitName = "SystemEjb", type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	@Override
	public User save(User user) {
		if (user.getId() == 0) {
			em.persist(user);
		} else {
			em.merge(user);
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getByName(String name, int status) {
		String strQry = (status < 2) ? "getUserByNameStatus" : "getUserByName";
		Query qry = em.createNamedQuery(strQry);
		qry.setParameter("name", name);
		if (status < 2) {
			qry.setParameter("status", status);
		}
		List<User> users = qry.getResultList();
		if (users.size() == 1) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public Role getRole(long id) {
		return em.find(Role.class, id);
	}

}
