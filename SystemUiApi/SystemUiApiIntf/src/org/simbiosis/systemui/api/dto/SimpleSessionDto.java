package org.simbiosis.systemui.api.dto;

import java.io.Serializable;

public class SimpleSessionDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -691572598319726680L;
	private String name;
	private String firstModule;
	private String redirect;
	private String baseRedirect;

	public SimpleSessionDto() {
		name = "";
		firstModule = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstModule() {
		return firstModule;
	}

	public void setFirstModule(String firstModule) {
		this.firstModule = firstModule;
	}

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

	public String getBaseRedirect() {
		return baseRedirect;
	}

	public void setBaseRedirect(String baseRedirect) {
		this.baseRedirect = baseRedirect;
	}

}
