
package com.appointment.schedular.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.appointment.schedular.dao.master.TenantDao;
import com.appointment.schedular.model.master.Tenant;
import com.appointment.schedular.tenant.MultiTenantConnectionProviderImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Dhyanandra
 *
 */

@Controller
@RequestMapping("/tenant")
public class TenantController {
	
	@Autowired
	TenantDao tenantRepo;
	
	@Autowired
	MultiTenantConnectionProviderImpl multiTenantConnectionProviderImpl;
	
	
	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/", 
					method = RequestMethod.POST, 
					consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String registerTenant(@RequestBody Map map) throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		Tenant tenant = mapper.convertValue(map, Tenant.class);
		
		String tenantKey = tenant.getName().replaceAll("[^a-zA-Z]+", "").toLowerCase().trim();
	      Optional<Tenant> previouslyStored = tenantRepo.findByTenantKey(tenantKey);
	      String response="Sorry your company name ("+tenant.getName()+")"+" is already taken";
	      if (!previouslyStored.isPresent()) {
	         tenant.setTenantKey(tenantKey);
	         tenantRepo.save(tenant);
	         multiTenantConnectionProviderImpl.addTenant(tenantKey);
	         response = "Successfully registered, your key is " + tenantKey;
	         return response;
	      }
		return new ObjectMapper().writeValueAsString(response);
	}
	
	

}
