package com.appointment.schedular.service;

import java.util.List;

import com.appointment.schedular.model.tenant.OrganizationDetails;
import com.appointment.schedular.model.tenant.OrganizationWorkingPolicy;

public interface OrganizationDetailsServices {
	
	public OrganizationDetails fetchOrganizationById(long organizationId);

	public OrganizationDetails saveOrganization(OrganizationDetails organizationDetails);

	public String persistOrganization(OrganizationDetails organizationDetails);
	
	//...........
	
	public OrganizationWorkingPolicy saveWorkingPolicy(OrganizationWorkingPolicy workingPolicy);

	public List<OrganizationWorkingPolicy> fetchWorkingPolicies();

	public List<OrganizationWorkingPolicy> fetchWorkingPolicy(String day);

	public OrganizationWorkingPolicy updateWorkingPolicy(long policyId);

	public OrganizationWorkingPolicy deleteWorkingPolicy(long policyId);

}
