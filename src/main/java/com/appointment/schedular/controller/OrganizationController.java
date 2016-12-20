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

import com.appointment.schedular.model.tenant.OrganizationDetails;
import com.appointment.schedular.model.tenant.OrganizationWorkingPolicy;
import com.appointment.schedular.service.OrganizationDetailsServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping({ "/organization" })
public class OrganizationController {

	@Autowired
	OrganizationDetailsServices organizationService;
	
	
	// ........xxxxxx..............xxxxxxx................xxxxxxx.............//
	
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin
	@RequestMapping(value = "/{organizationId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String fetchOrganizationInfo(@PathVariable("organizationId") long organizationId)
			throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(organizationService.fetchOrganizationById(organizationId));
	}

	// ........xxxxxx..............xxxxxxx................xxxxxxx.............//

	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OrganizationDetails saveOrganizationInfo(@RequestBody Map map) {
		ObjectMapper mapper = new ObjectMapper();
		OrganizationDetails organizationDetails = mapper.convertValue(map, OrganizationDetails.class);
		organizationService.saveOrganization(organizationDetails);
		return organizationDetails;
	}
	
	// ........xxxxxx..............xxxxxxx................xxxxxxx.............//
	
	  /************************* Working Policy *****************************/
	
	// ........xxxxxx..............xxxxxxx................xxxxxxx.............//
	
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin
	@RequestMapping(value = "/workingPolicy", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String fetchWorkingPolicy()
			throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(organizationService.fetchWorkingPolicies());
	}

	// ........xxxxxx..............xxxxxxx................xxxxxxx.............//

	@CrossOrigin
	@RequestMapping(value = "/workingPolicy/{day}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String fetchWorkingPolicy(@PathVariable("day") String day) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(organizationService.fetchWorkingPolicy(day));
	}
	
	// ........xxxxxx..............xxxxxxx................xxxxxxx.............//

	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/workingPolicy", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OrganizationWorkingPolicy saveWorkingPolicy(@RequestBody Map map) {
		ObjectMapper mapper = new ObjectMapper();
		OrganizationWorkingPolicy workingPolicy = mapper.convertValue(map, OrganizationWorkingPolicy.class);
		organizationService.saveWorkingPolicy(workingPolicy);
		return workingPolicy;
	}
	
	// ........xxxxxx..............xxxxxxx................xxxxxxx.............//

	
}
