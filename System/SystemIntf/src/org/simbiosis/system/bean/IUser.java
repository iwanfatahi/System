package org.simbiosis.system.bean;

import org.simbiosis.system.model.Role;
import org.simbiosis.system.model.User;

public interface IUser {
	User save(User user);

	User getByName(String name, int status);
	
	Role getRole(long id);
}
