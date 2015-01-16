package org.simbiosis.system.model;

import java.io.Serializable;
import java.util.Date;

public class Session implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6708805343158273603L;
	long id;
	String name;
	Date begin;
	Date end;
	int valid;
	User user;

	public Session() {

	}

	public Session(String name, User user) {
		id = 0;
		this.name = name;
		begin = new Date();
		valid = 1;
		this.user = user;
	}

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

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public int getValid() {
		return valid;
	}

	public void setValid(int valid) {
		this.valid = valid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
