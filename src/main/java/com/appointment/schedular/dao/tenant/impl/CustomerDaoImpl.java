package com.appointment.schedular.dao.tenant.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.appointment.schedular.dao.tenant.AbstractDao;
import com.appointment.schedular.dao.tenant.CustomerDao;
import com.appointment.schedular.model.tenant.CustomerDetails;

/**
 * @author Dhyanandra
 *
 */

@Repository("customerDao")
public class CustomerDaoImpl
		extends AbstractDao<Long, CustomerDetails>
		implements CustomerDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerDetails> fetchAllCustomer() {
		return createEntityCriteria().addOrder(Order.asc("customerId")).list();
	}

	@Override
	public CustomerDetails fetchCustomerById(long customerId) {
		return getByKey(customerId);
	}

	@Override
	public CustomerDetails saveCustomerDetails(CustomerDetails customerDetails) {
		return save(customerDetails);
	}

	@Override
	public CustomerDetails updateCustomer(long customerId) {
		return null;
	}

	@Override
	public CustomerDetails deleteCustomer(long customerId) {
		return null;
	}

	/** Address **/
	@Override
	public List<CustomerDetails> fetchAddressDetails(long customerId) {
		return null;
				/*createEntityCriteria()
			   .setProjection(Projections.projectionList()
				 .add(Projections.property("customerId"), "customerId")
				 .add(Projections.property("listOfAddresses"), "addresses"))
				 .add(Restrictions.eq("customerId", customerId))
				 .setResultTransformer(Transformers.aliasToBean(CustomerDetails.class))
				 .list();*/
	}

	
	@Override
	public List<CustomerDetails> updateAddress(long addressId) {
		return null;
	}

	
	@Override
	public List<CustomerDetails> deleteAddress(long customerId) {
		return null;
	}
}
