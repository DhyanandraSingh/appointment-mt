package com.appointment.schedular.dao.tenant.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.appointment.schedular.dao.tenant.AbstractDao;
import com.appointment.schedular.dao.tenant.ServiceCategoriesDao;
import com.appointment.schedular.model.tenant.ServiceCategories;

@Repository("ServiceCategoriesDao")
public class ServiceCategoriesDaoImpl 
       extends AbstractDao<Long, ServiceCategories> 
       implements ServiceCategoriesDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceCategories> fetchAllServiceCategories() {
		return createEntityCriteria().addOrder(Order.asc("serviceCatId")).list();
	}

	@Override
	public ServiceCategories fetchServiceCategoryById(long categoryId) {
		return  getByKey(categoryId);
	}

	@Override
	public ServiceCategories saveServiceCategory(ServiceCategories categories) {
		return save(categories);
	}

	@Override
	public ServiceCategories updateServiceCategory(long categoryId) {
		return null;
	}

	@Override
	public ServiceCategories deleteServiceCategory(long categoryId) {
		return null;
	}

}
