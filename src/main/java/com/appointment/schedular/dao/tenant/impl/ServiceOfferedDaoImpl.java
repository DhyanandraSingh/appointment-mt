package com.appointment.schedular.dao.tenant.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.appointment.schedular.dao.tenant.AbstractTenantDao;
import com.appointment.schedular.dao.tenant.ServicesOfferedDao;
import com.appointment.schedular.model.tenant.ServicesOffered;

@Repository("ServicesOfferedDao")
public class ServiceOfferedDaoImpl 
       extends AbstractTenantDao<Long, ServicesOffered> 
       implements ServicesOfferedDao  {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ServicesOffered> fetchAllService() {
		return createEntityCriteria().addOrder(Order.asc("serviceId")).list();
	}

	@Override
	public ServicesOffered fetchServiceById(long serviceId) {
		return getByKey(serviceId);
	}

	@Override
	public ServicesOffered saveService(ServicesOffered serviceOffered) {
		return save(serviceOffered);
	}

	@Override
	public ServicesOffered updateService(long serviceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServicesOffered deleteService(long serviceId) {
		// TODO Auto-generated method stub
		return null;
	}

}
