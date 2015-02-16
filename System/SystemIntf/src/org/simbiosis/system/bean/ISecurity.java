package org.simbiosis.system.bean;

import org.simbiosis.system.model.Session;

public interface ISecurity {
	String getRandomHash(int length);

	String registerSalt();

	int getSaltValid(String salt);

	void unregisterSalt(String salt);

	//

	void saveSession(Session session);

	Session getSession(String session);
}
