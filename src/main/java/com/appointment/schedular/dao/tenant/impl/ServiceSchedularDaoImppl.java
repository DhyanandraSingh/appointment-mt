package com.appointment.schedular.dao.tenant.impl;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.appointment.schedular.dao.tenant.AbstractDao;
import com.appointment.schedular.dao.tenant.ServiceSchedularDao;
import com.appointment.schedular.model.tenant.ServiceSchedule;

/**
 * @author Dhyanandra
 *
 */

@Repository("serviceSchelarDao")
public class ServiceSchedularDaoImppl 
	   extends AbstractDao<Long, ServiceSchedule>
	   implements ServiceSchedularDao {

	@Override
	public ServiceSchedule getScheduleById(long serviceScheduleId) {
		return getByKey(serviceScheduleId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceSchedule> getCustomerSchedule(long customerId) {
		return createEntityCriteria()
				.add(Restrictions.eq("customerId", customerId))
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceSchedule> getStaffSchedule(long staffId) {
		return createEntityCriteria()
			   .add(Restrictions.eq("staffId", staffId))
			   .list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceSchedule> getScheduleByDate(Date date) {
		return createEntityCriteria()
			   .add(Restrictions.like("timeSlot", date+"%"))
			   .list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceSchedule> getScheduleBookedByStaff(long staffId) {
		return createEntityCriteria()
			   .add(Restrictions.eq("bookedBy", staffId))
			   .list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceSchedule> getBookedScheduleForService(long serviceId) {
		return createEntityCriteria()
			   .add(Restrictions.eq("serviceId", serviceId))
			   .list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceSchedule> getBookedScheduleForServiceOnDate(long serviceId, Date date) {
		return createEntityCriteria()
				.add(Restrictions.eq("serviceId", serviceId))
				.add(Restrictions.like("timeSlot", date+"%"))
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceSchedule> getBookedScheduleForServiceOnTime(long serviceId, Time time) {
		return createEntityCriteria()
				.add(Restrictions.eq("serviceId", serviceId))
				.add(Restrictions.like("timeSlot", "%"+time))
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceSchedule> getBookedScheduleForServiceOnDateTimeSlot(long serviceId, Date date, Time time) {
		return createEntityCriteria()
				.add(Restrictions.eq("serviceId", serviceId))
				.add(Restrictions.like("timeSlot", date+" "+time))
				.list();
	}

	
	@Override
	public List<ServiceSchedule> getBookedScheduleForServiceOnDateForEmployee(long employeeId, long SrviceId,
			Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServiceSchedule> getBookedScheduleForServiceOnTimeForEmployee(long employeeId, long SrviceId,
			Time time) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
