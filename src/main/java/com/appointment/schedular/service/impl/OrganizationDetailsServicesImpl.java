package com.appointment.schedular.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appointment.schedular.dao.tenant.OrganizationDetailsDao;
import com.appointment.schedular.dao.tenant.WorkingPolicyDao;
import com.appointment.schedular.model.tenant.OrganizationDetails;
import com.appointment.schedular.model.tenant.OrganizationWorkingPolicy;
import com.appointment.schedular.service.OrganizationDetailsServices;

@Service("OrganizationDetailsServicesImpl")
@Transactional("tenantTransactionManager")
public class OrganizationDetailsServicesImpl 
	   implements OrganizationDetailsServices{

	@Autowired
	OrganizationDetailsDao organizationDao;
	
	@Autowired
	WorkingPolicyDao workingPolicyDao;
	
	@Override
	public OrganizationDetails fetchOrganizationById(long organizationId) {
		return organizationDao.fetchOrganizationById(organizationId);
	}

	@Override
	public OrganizationDetails saveOrganization(OrganizationDetails organizationDetails) {
		return organizationDao.saveOrganization(organizationDetails);
	}
	
	@Override
	public String persistOrganization(OrganizationDetails organizationDetails) {
		return organizationDao.persistOrganization(organizationDetails);
	}
	
	//......
	
	@Override
	public OrganizationWorkingPolicy saveWorkingPolicy(OrganizationWorkingPolicy workingPolicy) {
		return workingPolicyDao.saveWorkingPolicy(workingPolicy);
	}

	@Override
	public List<OrganizationWorkingPolicy> fetchWorkingPolicies() {
		return workingPolicyDao.fetchWorkingPolicies();
	}

	@Override
	public List<OrganizationWorkingPolicy> fetchWorkingPolicy(String day) {
		return workingPolicyDao.fetchWorkingPolicy(day);
	}

	@Override
	public OrganizationWorkingPolicy updateWorkingPolicy(long policyId) {
		return null;
	}

	@Override
	public OrganizationWorkingPolicy deleteWorkingPolicy(long policyId) {
		return null;
	}
	
}
