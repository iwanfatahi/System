package org.simbiosis.systemui.model;

import java.io.Serializable;

public class Application implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4936969011583392033L;
	long id;
	String name;

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

}
