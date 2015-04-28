package org.simbiosis.system.bean;

import org.simbiosis.system.model.User;

public interface IUser {
	User save(User user);

	User getUserByName(String name);

	User getActiveUserByName(String name);
}
