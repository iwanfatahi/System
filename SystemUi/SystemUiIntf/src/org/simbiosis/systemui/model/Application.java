package org.simbiosis.systemui.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Application implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4936969011583392033L;
	long id;
	String name;
	List<Menu> menus = new ArrayList<Menu>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

}
