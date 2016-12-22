/**
 * 
 */
package com.appointment.schedular.service.impl;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appointment.schedular.dao.tenant.ServiceSchedularDao;
import com.appointment.schedular.model.tenant.ServiceSchedule;
import com.appointment.schedular.service.ScheduledService;

/**
 * @author Dhyanandra
 *
 */

@Service("ServiceScheduledImpl")
@Transactional("tenantTransactionManager")
public class ServiceScheduledImpl implements ScheduledService  {

	@Autowired
	ServiceSchedularDao serviceScheduledDao;
	
	@Override
	public ServiceSchedule getScheduleById(long serviceScheduleId) {
		return null;
	}

	@Override
	public List<ServiceSchedule> getCustomerSchedule(long customerId) {
		return null;
	}

	@Override
	public List<ServiceSchedule> getStaffSchedule(long staffId) {
		return null;
	}

	@Override
	public List<ServiceSchedule> getScheduleByDate(Date date) {
		return null;
	}

	@Override
	public List<ServiceSchedule> getScheduleBookedByStaff(long StaffId) {
		return null;
	}

	@Override
	public List<ServiceSchedule> getBookedScheduleForService(long ServiceId) {
		return null;
	}

	@Override
	public List<ServiceSchedule> getBookedScheduleForServiceOnDate(long SrviceId, Date date) {
		return null;
	}

	@Override
	public List<ServiceSchedule> getBookedScheduleForServiceOnTime(long SrviceId, Time time) {
		return null;
	}

	@Override
	public List<ServiceSchedule> getBookedScheduleForServiceOnDateTimeSlot(long SrviceId, Date date, Time time) {
		return null;
	}

}
