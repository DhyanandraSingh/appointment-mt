package com.appointment.schedular.controller;

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

import com.appointment.schedular.model.tenant.ServiceCategories;
import com.appointment.schedular.model.tenant.ServicesOffered;
import com.appointment.schedular.service.ServicesProviderServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping({ "/services" })
public class ServicesController {

	@Autowired
	ServicesProviderServices serviceprovider;

	// ........xxxxxx..............xxxxxxx................xxxxxxx.............//
	
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin
	@RequestMapping(value = "/category", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String fetchserviceCategory() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(serviceprovider.fetchAllServiceCategories());
	}

	// ........xxxxxx..............xxxxxxx................xxxxxxx.............//

	@CrossOrigin
	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String fetchserviceCategory(@PathVariable("categoryId") long categoryId)
			throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(serviceprovider.fetchServiceCategoryById(categoryId));
	}

	// ........xxxxxx..............xxxxxxx................xxxxxxx.............//

	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/category", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ServiceCategories saveServiceCategory(@RequestBody Map map) {
		ObjectMapper mapper = new ObjectMapper();
		ServiceCategories category = mapper.convertValue(map, ServiceCategories.class);
		serviceprovider.saveServiceCategory(category);
		return category;
	}

	// ........xxxxxx..............xxxxxxx................xxxxxxx.............//

	  /************************* Services Offered ****************************/

	// ........xxxxxx..............xxxxxxx................xxxxxxx.............//
	
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin
	@RequestMapping(value = "/serviceOffered", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String fetchsServices() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(serviceprovider.fetchAllService());
	}

	// ........xxxxxx..............xxxxxxx................xxxxxxx.............//

	@CrossOrigin
	@RequestMapping(value = "/serviceOffered/{serviceId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String fetchservice(@PathVariable("serviceId") long serviceId)
			throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(serviceprovider.fetchServiceCategoryById(serviceId));
	}

	// ........xxxxxx..............xxxxxxx................xxxxxxx.............//

	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/serviceOffered", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ServicesOffered saveService(@RequestBody Map map) {
		ObjectMapper mapper = new ObjectMapper();
		ServicesOffered service = mapper.convertValue(map, ServicesOffered.class);
		serviceprovider.saveService(service);
		return service;
	}


	
	
	

}
