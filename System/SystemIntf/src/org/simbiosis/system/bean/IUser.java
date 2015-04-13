package org.simbiosis.system.bean;

import org.simbiosis.system.model.User;

public interface IUser {
	User getUserByName(String name);

	User getActiveUserByName(String name);
}
