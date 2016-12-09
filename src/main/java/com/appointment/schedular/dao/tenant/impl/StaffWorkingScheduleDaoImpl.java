/**
 * 
 */
package com.appointment.schedular.dao.tenant.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.appointment.schedular.dao.tenant.AbstractDao;
import com.appointment.schedular.dao.tenant.StaffWorkingScheduleDao;
import com.appointment.schedular.model.tenant.StaffWorkingSchedule;

/**
 * @author Dhyanandra
 *
 */

@Repository("staffWorkingScheduleDao")
public class StaffWorkingScheduleDaoImpl
       extends AbstractDao<Long, StaffWorkingSchedule >
	   implements StaffWorkingScheduleDao{

	
	@Override
	public String deleteWorkingSchedule(long workScheduleId) {
		   return null;
	}

	
	@Override
	public StaffWorkingSchedule updateWorkingSchedule(long workScheduleId,
													  StaffWorkingSchedule workSchedule) {
		return null;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<StaffWorkingSchedule> getStaffWorkingSchedule(long staffId) {
		return createEntityCriteria()
				.add(Restrictions.eq("staffId", staffId ))
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StaffWorkingSchedule> getStaffWorkingScheduleOfDay(long staffId, String day) {
		return createEntityCriteria()
			.add(Restrictions.eq("staffId", staffId))
			.add(Restrictions.eq("day", day))
			.addOrder(Order.desc("shift"))
			.list();
	}
	
	
}
