package com.appointment.schedular.dao.tenant;

import java.util.List;

import com.appointment.schedular.model.tenant.ServiceCategories;

/**
 * @author Dhyanandra
 *
 */
public interface ServiceCategoriesDao {

	public List<ServiceCategories> fetchAllServiceCategories();

	public ServiceCategories fetchServiceCategoryById(long categoryId);

	public ServiceCategories saveServiceCategory(ServiceCategories categories);

	public ServiceCategories updateServiceCategory(long categoryId);

	public ServiceCategories deleteServiceCategory(long categoryId);

}
