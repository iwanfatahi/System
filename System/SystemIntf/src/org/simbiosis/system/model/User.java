package org.simbiosis.system.model;

import java.io.Serializable;
import java.util.Date;

/**
 * User digunakan untuk memenej user yang boleh mengakses sistem dengan syarat
 * dan kondisi tertentu. User yang ada pada modul ini hanya melayani kebutuhan
 * dasar untuk proses otentikasi. Untuk membuat informasi user yang lebih
 * komprehensif
 * 
 * @author Iwan Agus Fatahi (iwanfatahi@gmail.com)
 * @version %I%, %G%
 */
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5481086506047938296L;
	long id;
	String name;
	String realName;
	String password;
	String email;
	int level;
	int active;
	int type;
	Role role;

	Company company;
	Branch branch;
	SubBranch subBranch;

	Date tsCreate;
	long userCreate;
	Date tsUpdate;
	long userUpdate;

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

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	public SubBranch getSubBranch() {
		return subBranch;
	}

	public void setSubBranch(SubBranch subBranch) {
		this.subBranch = subBranch;
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

	public Date getTsCreate() {
		return tsCreate;
	}

	public void setTsCreate(Date tsCreate) {
		this.tsCreate = tsCreate;
	}

	public long getUserCreate() {
		return userCreate;
	}

	public void setUserCreate(long userCreate) {
		this.userCreate = userCreate;
	}

	public Date getTsUpdate() {
		return tsUpdate;
	}

	public void setTsUpdate(Date tsUpdate) {
		this.tsUpdate = tsUpdate;
	}

	public long getUserUpdate() {
		return userUpdate;
	}

	public void setUserUpdate(long userUpdate) {
		this.userUpdate = userUpdate;
	}

}
