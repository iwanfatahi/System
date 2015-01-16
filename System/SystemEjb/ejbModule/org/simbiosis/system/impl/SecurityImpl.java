package org.simbiosis.system.impl;

import java.security.SecureRandom;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.jboss.security.Base64Utils;
import org.simbiosis.system.bean.ISecurity;
import org.simbiosis.system.model.Salt;
import org.simbiosis.system.model.Session;

@Stateless
@Remote(ISecurity.class)
public class SecurityImpl implements ISecurity {

	@PersistenceContext(unitName = "SystemEjb", type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	@Override
	public String getRandomHash(int length) {
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[length];
		random.nextBytes(bytes);
		return Base64Utils.tob64(bytes);
	}

	@Override
	public String registerSalt() {
		Salt salt = new Salt(getRandomHash(8));
		em.persist(salt);
		return salt.getValue();
	}

	@Override
	public void unregisterSalt(String value) {
		Salt salt = em.find(Salt.class, value);
		salt.setValid(0);
	}

	@Override
	public int getSaltValid(String value) {
		Salt salt = em.find(Salt.class, value);
		return salt.getValid();
	}

	@Override
	public void saveSession(Session session) {
		if (session.getId() == 0) {
			em.persist(session);
		} else {
			em.merge(session);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Session getSession(String name) {
		Query qry = em.createNamedQuery("getSessionByName");
		qry.setParameter("name", name);
		List<Session> sessions = qry.getResultList();
		if (sessions.size() > 0) {
			return sessions.get(0);
		}
		return null;
	}

}
