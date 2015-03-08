package org.simbiosis.system.model;

import java.io.Serializable;

public class Company implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3341881262415002002L;
	long id;
	String code;
	String name;
	String address;
	String datapath;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDatapath() {
		return datapath;
	}

	public void setDatapath(String datapath) {
		this.datapath = datapath;
	}
}
