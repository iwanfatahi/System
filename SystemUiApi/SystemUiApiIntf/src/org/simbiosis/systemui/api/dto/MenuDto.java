package org.simbiosis.systemui.api.dto;

import org.simbiosis.systemui.model.Menu;

public class MenuDto extends Menu {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5186145470199478350L;
	String grandParentTitle;
	String parentTitle;
	String link;

	public String getGrandParentTitle() {
		return grandParentTitle;
	}

	public void setGrandParentTitle(String grandParentTitle) {
		this.grandParentTitle = grandParentTitle;
	}

	public String getParentTitle() {
		return parentTitle;
	}

	public void setParentTitle(String parentTitle) {
		this.parentTitle = parentTitle;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
