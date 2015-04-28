package org.simbiosis.system.api.bean;

import org.simbiosis.system.model.User;

public interface IUserManager {
	User save(long company, long branch, User user);

	User save(User user);
}
