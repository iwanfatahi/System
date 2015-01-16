package org.simbiosis.systemui.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CompanyApplication implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4399368519317938051L;
	long id;
	long company;
	List<Application> applications = new ArrayList<Application>();

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

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

}
