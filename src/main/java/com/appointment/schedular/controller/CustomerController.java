/*package com.appointment.schedular.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.appointment.schedular.model.tenant.CustomerDetails;
import com.appointment.schedular.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	// ........xxxxxx..............xxxxxxx................xxxxxxx.............//
	
		@ResponseStatus(HttpStatus.OK)
		@CrossOrigin
		@RequestMapping(value = "/", 
						method = RequestMethod.GET, 
						produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String fetchCustomer() throws JsonProcessingException {
			return new ObjectMapper().writeValueAsString(customerService.fetchAllCustomer());
		}

		// ........xxxxxx..............xxxxxxx................xxxxxxx.............//

		@CrossOrigin
		@RequestMapping(value = "/{customerId}", 
						method = RequestMethod.GET, 
						produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String fetchCustomer(@PathVariable("customerId") long customerId)
				throws JsonProcessingException {
			return new ObjectMapper().writeValueAsString(customerService.fetchCustomerById(customerId));
		}

		// ........xxxxxx..............xxxxxxx................xxxxxxx.............//

		@SuppressWarnings("rawtypes")
		@CrossOrigin
		@RequestMapping(value = "/", 
						method = RequestMethod.POST, 
						consumes = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody CustomerDetails saveCustomer(@RequestBody Map map) {
			ObjectMapper mapper = new ObjectMapper();
			CustomerDetails customer = mapper.convertValue(map, CustomerDetails.class);
			customerService.saveCustomerDetails(customer);
			return customer;
		}
	
   // ........xxxxxx..............xxxxxxx................xxxxxxx.............//
						         	address 
   // ........xxxxxx..............xxxxxxx................xxxxxxx.............//

		@CrossOrigin
		@RequestMapping(value = "{customerId}/address/", 
						method = RequestMethod.GET, 
						produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String fetchCustomerAddress(@PathVariable("customerId") long customerId)
				throws JsonProcessingException {
			return new ObjectMapper().writeValueAsString(customerService.fetchAddressDetails(customerId));
		}

		// ........xxxxxx..............xxxxxxx................xxxxxxx.............//

	
}
*/