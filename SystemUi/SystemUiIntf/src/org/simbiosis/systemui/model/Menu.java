package org.simbiosis.systemui.model;

import java.io.Serializable;

public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5330497849439890759L;
	long id;
	Application application;
	String title;
	String place;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
