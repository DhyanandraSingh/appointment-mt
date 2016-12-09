package com.appointment.schedular.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appointment.schedular.dao.tenant.CustomerDao;
import com.appointment.schedular.model.tenant.CustomerDetails;
import com.appointment.schedular.service.CustomerService;

/**
 * @author Dhyanandra
 *
 */

@Service("CustomerServiceImpl")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public List<CustomerDetails> fetchAllCustomer() {
		return customerDao.fetchAllCustomer();
	}

	
	@Override
	public CustomerDetails fetchCustomerById(long customerId) {
		return customerDao.fetchCustomerById(customerId);
	}

	
	@Override
	public CustomerDetails saveCustomerDetails(CustomerDetails customerDetails) {
		return customerDao.saveCustomerDetails(customerDetails);
	}

	@Override
	public CustomerDetails updateCustomer(long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDetails deleteCustomer(long customerId) {
		// TODO Auto-generated method stub
		return null;
	}


	/** Address **/
	
	@Override
	public List<CustomerDetails> fetchAddressDetails(long customerId) {
		return customerDao.fetchAddressDetails(customerId);
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
