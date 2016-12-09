package com.appointment.schedular.service;

import java.util.List;

import com.appointment.schedular.model.tenant.ServiceCategories;
import com.appointment.schedular.model.tenant.ServicesOffered;

/**
 * @author Dhyanandra
 *
 */
public interface ServicesProviderServices {
	
	public List<ServiceCategories> fetchAllServiceCategories();

	public ServiceCategories fetchServiceCategoryById(long categoryId);

	public ServiceCategories saveServiceCategory(ServiceCategories categories);

	public ServiceCategories updateServiceCategory(long categoryId);

	public ServiceCategories deleteServiceCategory(long categoryId);

	// ........xxxxxx..............xxxxxxx................xxxxxxx.............//

	   /*********************** services Offered ****************************/

	// ........xxxxxx..............xxxxxxx................xxxxxxx.............//

	public List<ServicesOffered> fetchAllService();

	public ServicesOffered fetchServiceById(long serviceId);

	public ServicesOffered saveService(ServicesOffered serviceOffered);

	public ServicesOffered updateService(long serviceId);

	public ServicesOffered deleteService(long serviceId);

	
}
