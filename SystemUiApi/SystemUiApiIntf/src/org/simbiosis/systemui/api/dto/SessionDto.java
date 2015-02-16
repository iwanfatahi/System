package org.simbiosis.systemui.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SessionDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5071377573861375067L;

	String sessionName;
	String userName;
	String userRealName;
	String companyName;
	String branchName;
	List<MenuDto> menuItems = new ArrayList<MenuDto>();

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public List<MenuDto> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuDto> menuItems) {
		this.menuItems = menuItems;
	}

}
