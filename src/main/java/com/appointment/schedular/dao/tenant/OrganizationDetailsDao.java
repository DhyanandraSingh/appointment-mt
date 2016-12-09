package com.appointment.schedular.dao.tenant;

import com.appointment.schedular.model.tenant.OrganizationDetails;

/**
 * @author Dhyanandra
 *
 */
public interface OrganizationDetailsDao {
	
	public OrganizationDetails fetchOrganizationById(long organizationId);
	
	public OrganizationDetails saveOrganization(OrganizationDetails organizationDetails);
	
	// method to persist to data
	public String persistOrganization(OrganizationDetails organizationDetails);
	
	//public OrganizationDetails updateOrganization(long organizationId);
	//public OrganizationDetails deleteOrganization(long organizationId);
	
	

}
