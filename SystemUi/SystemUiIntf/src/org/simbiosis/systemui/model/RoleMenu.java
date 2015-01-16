package org.simbiosis.systemui.model;

import java.io.Serializable;

public class RoleMenu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4011693774058317649L;
	long id;
	long role;
	Menu menu;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRole() {
		return role;
	}

	public void setRole(long role) {
		this.role = role;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
