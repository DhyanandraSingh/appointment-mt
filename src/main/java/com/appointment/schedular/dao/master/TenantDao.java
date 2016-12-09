/**
 * 
 */
package com.appointment.schedular.dao.master;

/**
 * @author Dhyanandra
 *
 */
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.appointment.schedular.model.master.Tenant;


/**
 * @author Dhyanandra
 *
 */
public interface TenantDao extends CrudRepository<Tenant, Serializable>{
	
	public Optional<Tenant> findByTenantKey(String tenantKey);

    @Override
    public List<Tenant> findAll();

}
