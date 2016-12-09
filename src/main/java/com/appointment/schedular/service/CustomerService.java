package com.appointment.schedular.service;

import java.util.List;

import com.appointment.schedular.model.tenant.CustomerDetails;

/**
 * @author Dhyanandra
 *
 */
public interface CustomerService {
	
	public List<CustomerDetails> fetchAllCustomer();

	public CustomerDetails fetchCustomerById(long customerId);

	public CustomerDetails saveCustomerDetails(CustomerDetails customerDetails);

	public CustomerDetails updateCustomer(long customerId);

	public CustomerDetails deleteCustomer(long customerId);
	
	/** Address **/
	
	public List<CustomerDetails> fetchAddressDetails(long customerId);
	
	public List<CustomerDetails> updateAddress(long addressId);
	
	public List<CustomerDetails> deleteAddress(long customerId);
	
	
	
	
}
