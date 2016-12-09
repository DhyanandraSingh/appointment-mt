package com.appointment.schedular.dao.tenant;

import java.util.List;

import com.appointment.schedular.model.tenant.OrganizationWorkingPolicy;

public interface WorkingPolicyDao {
    
	public OrganizationWorkingPolicy saveWorkingPolicy(OrganizationWorkingPolicy workingPolicy);
	
	public List<OrganizationWorkingPolicy> fetchWorkingPolicies();
	
	public List<OrganizationWorkingPolicy> fetchWorkingPolicy(String day);
	
	public OrganizationWorkingPolicy updateWorkingPolicy(long policyId);
	
	public OrganizationWorkingPolicy deleteWorkingPolicy(long policyId);
}
