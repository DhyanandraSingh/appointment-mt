package com.appointment.schedular.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appointment.schedular.dao.tenant.ServiceCategoriesDao;
import com.appointment.schedular.dao.tenant.ServicesOfferedDao;
import com.appointment.schedular.model.tenant.ServiceCategories;
import com.appointment.schedular.model.tenant.ServicesOffered;
import com.appointment.schedular.service.ServicesProviderServices;

@Service("ServicesProviderServicesImpl")
@Transactional
public class ServicesProviderServicesImpl implements ServicesProviderServices {
	
	@Autowired
	ServiceCategoriesDao serviceCategoriesDao;
	
	@Autowired
	ServicesOfferedDao serviceOfferedDao;
	
	@Override
	public List<ServiceCategories> fetchAllServiceCategories() {
		return serviceCategoriesDao.fetchAllServiceCategories();
	}

	@Override
	public ServiceCategories fetchServiceCategoryById(long categoryId) {
		return serviceCategoriesDao.fetchServiceCategoryById(categoryId);
	}

	@Override
	public ServiceCategories saveServiceCategory(ServiceCategories categories) {
		return serviceCategoriesDao.saveServiceCategory(categories);
	}

	@Override
	public ServiceCategories updateServiceCategory(long categoryId) {
		return null;
	}

	@Override
	public ServiceCategories deleteServiceCategory(long categoryId) {
		return null;
	}
	
	// ........xxxxxx..............xxxxxxx................xxxxxxx.............//

	   /*********************** services Offered ****************************/

	// ........xxxxxx..............xxxxxxx................xxxxxxx.............//
	
	

	@Override
	public List<ServicesOffered> fetchAllService() {
		return serviceOfferedDao.fetchAllService();
	}

	@Override
	public ServicesOffered fetchServiceById(long serviceId) {
		return serviceOfferedDao.fetchServiceById(serviceId);
	}

	@Override
	public ServicesOffered saveService(ServicesOffered serviceOffered) {
		return serviceOfferedDao.saveService(serviceOffered);
	}

	@Override
	public ServicesOffered updateService(long serviceId) {
		return null;
	}

	@Override
	public ServicesOffered deleteService(long serviceId) {
		return null;
	}

	
}
