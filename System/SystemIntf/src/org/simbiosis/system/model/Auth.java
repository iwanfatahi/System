package org.simbiosis.system.model;

import java.io.Serializable;
import java.util.Date;

public class Auth implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6517205217347744748L;
	long id;
	String description;
	Date timestamp;
	User user;
	int level;
	int active;
	String key;
	User authorizer;
	Company company;
	Branch branch;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getAuthorizer() {
		return authorizer;
	}

	public void setAuthorizer(User authorizer) {
		this.authorizer = authorizer;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
