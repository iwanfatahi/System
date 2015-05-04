package org.simbiosis.system.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.simbiosis.system.bean.IOrganisation;
import org.simbiosis.system.model.Branch;
import org.simbiosis.system.model.Company;
import org.simbiosis.system.model.SubBranch;

@Stateless
@Remote(IOrganisation.class)
public class OrganisationImpl implements IOrganisation {

	@PersistenceContext(unitName = "SystemEjb", type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	@Override
	public Company getCompany(long company) {
		return em.find(Company.class, company);
	}

	@Override
	public Branch getBranch(long branch) {
		return em.find(Branch.class, branch);
	}

	@Override
	public SubBranch getSubBranch(long subBranch) {
		return em.find(SubBranch.class, subBranch);
	}

}
