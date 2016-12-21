package com.appointment.schedular.dao.tenant.impl;

import org.springframework.stereotype.Repository;

import com.appointment.schedular.dao.tenant.AbstractTenantDao;
import com.appointment.schedular.dao.tenant.OrganizationDetailsDao;
import com.appointment.schedular.model.tenant.OrganizationDetails;

@Repository("OrganizationDetailsDao")
public class OrganizationDetailsDaoImpl extends AbstractTenantDao<Long, OrganizationDetails>
		implements OrganizationDetailsDao {

	@Override
	public OrganizationDetails fetchOrganizationById(long organizationId) {
		return getByKey(organizationId);
	}
	
	@Override
	public OrganizationDetails saveOrganization(OrganizationDetails organizationDetails) {
		return save(organizationDetails);
	}
	
	@Override
	public String persistOrganization(OrganizationDetails organizationDetails) {
		 persist(organizationDetails);
		 return "success";
	}

}
