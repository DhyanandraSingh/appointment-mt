/**
 * 
 *//*
package com.appointment.schedular.dao.master.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.appointment.schedular.dao.master.AbstractMasterDao;
import com.appointment.schedular.dao.master.TenantDao;
import com.appointment.schedular.model.master.Tenant;

*//**
 * @author Dhyanandra
 *
 *//*

@Repository("tenantDao")
@Transactional("masterTransactionManager")
public class TenantDaoImpl extends AbstractMasterDao<Long, Tenant>
implements TenantDao{

	
	@Override
	public Object findByTenantKey(String tenantKey) {
		
		return createEntityCriteria().add(Restrictions.eq("tenantKey", tenantKey));
		
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tenant> findAll() {
		return createEntityCriteria().addOrder(Order.asc("tenantId")).list();
	}
	
	public Tenant save(Tenant tenant){
		return save(tenant);
	}

	

}
*/