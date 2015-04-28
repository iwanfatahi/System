package org.simbiosis.system.bean;

import org.simbiosis.system.model.Branch;
import org.simbiosis.system.model.Company;

public interface IOrganisation {
	Company getCompany(long company);

	Branch getBranch(long branch);
}
