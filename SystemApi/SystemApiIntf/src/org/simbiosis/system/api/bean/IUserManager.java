package org.simbiosis.system.api.bean;

import org.simbiosis.system.model.User;

public interface IUserManager {
	User saveAsMember(long company, long branch, long subBranch, User user);

	User save(long company, long branch, long subBranch, User user);

	User save(User user);
}
