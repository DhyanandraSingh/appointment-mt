package com.appointment.schedular.dao.tenant.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.appointment.schedular.dao.tenant.AbstractDao;
import com.appointment.schedular.dao.tenant.WorkingPolicyDao;
import com.appointment.schedular.model.tenant.OrganizationWorkingPolicy;

@Repository("WorkingPolicyDao")
public class WorkingPolicyDaoImpl 
	   extends AbstractDao<Long, OrganizationWorkingPolicy> 
       implements WorkingPolicyDao {

	@Override
	public OrganizationWorkingPolicy saveWorkingPolicy(OrganizationWorkingPolicy workingPolicy) {
		return save(workingPolicy);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrganizationWorkingPolicy> fetchWorkingPolicies() {
		return  createEntityCriteria()
				.addOrder(Order.asc("policyId"))
				/*.setProjection(Projections.projectionList()
						.add(Projections.groupProperty("day").as("day"))
						.add(Projections.property("policyId").as("policyId"))
						.add(Projections.property("startTime").as("startTime"))
						.add(Projections.property("endTime").as("endTime"))
						)*/
						.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrganizationWorkingPolicy> fetchWorkingPolicy(String day) {
		return   createEntityCriteria()
				 .add(Restrictions.eq("day", day)).list();
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
