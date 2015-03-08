package org.simbiosis.system.model;

import java.io.Serializable;

public class SubBranch implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6290869094034231385L;
	long id;
	String code;
	String name;
	String address;

	long company;
	Branch branch;

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

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public long getCompany() {
		return company;
	}

	public void setCompany(long company) {
		this.company = company;
	}

}
