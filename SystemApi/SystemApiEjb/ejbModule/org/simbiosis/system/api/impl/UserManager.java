package org.simbiosis.system.api.impl;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.simbiosis.system.api.bean.IUserManager;
import org.simbiosis.system.bean.IOrganisation;
import org.simbiosis.system.bean.IUser;
import org.simbiosis.system.model.Branch;
import org.simbiosis.system.model.Company;
import org.simbiosis.system.model.Role;
import org.simbiosis.system.model.SubBranch;
import org.simbiosis.system.model.User;

@Stateless
@Remote(IUserManager.class)
public class UserManager implements IUserManager {

	@EJB(lookup = "java:global/System/SystemEjb/UserImpl")
	IUser iUser;

	@EJB(lookup = "java:global/System/SystemEjb/OrganisationImpl")
	IOrganisation iOrganisation;

	@Override
	public User save(User user) {
		Date today = new Date();
		if (user.getId() == 0) {
			user.setTsCreate(today);
		} else {
			user.setTsUpdate(today);
		}
		return iUser.save(user);
	}

	@Override
	public User save(long lcompany, long lbranch, long lsubBranch, User user) {
		Company company = iOrganisation.getCompany(lcompany);
		Branch branch = iOrganisation.getBranch(lbranch);
		SubBranch subBranch = iOrganisation.getSubBranch(lsubBranch);
		user.setCompany(company);
		user.setBranch(branch);
		user.setSubBranch(subBranch);
		return save(user);
	}

	@Override
	public User saveAsMember(long lcompany, long lbranch, long lsubBranch,
			User user) {
		Company company = iOrganisation.getCompany(lcompany);
		Branch branch = iOrganisation.getBranch(lbranch);
		SubBranch subBranch = iOrganisation.getSubBranch(lsubBranch);
		user.setCompany(company);
		user.setBranch(branch);
		user.setSubBranch(subBranch);
		// Set untuk member
		// FIXME: masih di hardcode...
		Role role = iUser.getRole(5);
		user.setRole(role);
		user.setType(3);
		user.setLevel(7);
		//
		return save(user);
	}

}
