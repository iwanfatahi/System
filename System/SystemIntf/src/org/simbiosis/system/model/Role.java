package org.simbiosis.system.model;

import java.io.Serializable;

public class Role implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5787628140750069443L;
	long id;
	String name;
	String description;
	Company company;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
