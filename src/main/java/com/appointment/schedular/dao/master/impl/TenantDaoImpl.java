/**
 * 
 */
package com.appointment.schedular.dao.master.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.appointment.schedular.dao.master.AbstractMasterDao;
import com.appointment.schedular.dao.master.TenantDao;
import com.appointment.schedular.model.master.Tenant;

/**
 * @author Dhyanandra
 *
 */

@Repository("tenantDao")
@Transactional("masterTransactionManager")
public class TenantDaoImpl extends AbstractMasterDao<Long, Tenant>
implements TenantDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public Optional<Tenant> findByTenantKey(String tenantKey) {
		return (Optional<Tenant>) createEntityCriteria()
		     					  .add(Restrictions.eq("tenantKey", tenantKey))
		     					  .uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tenant> findAll() {
		return createEntityCriteria().addOrder(Order.asc("tenantKey")).list();
	}
	
	public Tenant save(Tenant tenant){
		return save(tenant);
	}

	

}
