package org.simbiosis.systemui.model;

import java.io.Serializable;

public class CompanyApplication implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4399368519317938051L;
	long id;
	long company;
	Application application;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCompany() {
		return company;
	}

	public void setCompany(long company) {
		this.company = company;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

}
