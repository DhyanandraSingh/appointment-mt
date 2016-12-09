package com.appointment.schedular.dao.tenant;

import java.util.List;

import com.appointment.schedular.model.tenant.ServicesOffered;

/**
 * @author Dhyanandra
 *
 */
public interface ServicesOfferedDao {
	
	public List<ServicesOffered> fetchAllService();

	public ServicesOffered fetchServiceById(long serviceId);

	public ServicesOffered saveService(ServicesOffered serviceOffered);

	public ServicesOffered updateService(long serviceId);

	public ServicesOffered deleteService(long serviceId);
	
}
