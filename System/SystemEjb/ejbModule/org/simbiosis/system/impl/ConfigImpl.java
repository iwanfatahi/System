package org.simbiosis.system.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.simbiosis.system.bean.IConfig;
import org.simbiosis.system.model.Config;

@Stateless
@Remote(IConfig.class)
public class ConfigImpl implements IConfig {

	@PersistenceContext(unitName = "SystemEjb", type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public Config get(long company, String key) {
		Query qry = em.createNamedQuery("getConfigValue");
		qry.setParameter("company", company);
		qry.setParameter("key", key);
		List<Config> results = qry.getResultList();
		if (results.size() > 0) {
			return results.get(0);
		}
		return null;
	}

	@Override
	public void save(Config config) {
		em.merge(config);
	}

}
