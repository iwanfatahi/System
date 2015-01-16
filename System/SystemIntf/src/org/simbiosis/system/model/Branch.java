package org.simbiosis.system.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Branch implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1693272435654117908L;
	long id;
	String code;
	String name;
	String address;
	long param1;
	long param2;
	long param3;
	long param4;

	Company company;
	List<SubBranch> subBranches = new ArrayList<SubBranch>();

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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<SubBranch> getSubBranches() {
		return subBranches;
	}

	public void setSubBranches(List<SubBranch> subBranches) {
		this.subBranches = subBranches;
	}

	public long getParam1() {
		return param1;
	}

	public void setParam1(long param1) {
		this.param1 = param1;
	}

	public long getParam2() {
		return param2;
	}

	public void setParam2(long param2) {
		this.param2 = param2;
	}

	public long getParam3() {
		return param3;
	}

	public void setParam3(long param3) {
		this.param3 = param3;
	}

	public long getParam4() {
		return param4;
	}

	public void setParam4(long param4) {
		this.param4 = param4;
	}
}
