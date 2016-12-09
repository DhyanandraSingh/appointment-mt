/**
 * 
 */
package com.appointment.schedular.dao.tenant;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.appointment.schedular.model.tenant.ServiceSchedule;

/**
 * @author Dhyanandra
 *
 */

public interface ServiceSchedularDao {
	
	public ServiceSchedule getScheduleById(long serviceScheduleId);
	
	public List<ServiceSchedule> getCustomerSchedule(long customerId);
	
	public List<ServiceSchedule> getStaffSchedule(long staffId);
	
	public List<ServiceSchedule> getScheduleByDate(Date date);
	
	public List<ServiceSchedule> getScheduleBookedByStaff(long StaffId);
	
	public List<ServiceSchedule> getBookedScheduleForService(long ServiceId);
	
	public List<ServiceSchedule> getBookedScheduleForServiceOnDate(long SrviceId, Date date);
	
	public List<ServiceSchedule> getBookedScheduleForServiceOnTime(long SrviceId, Time time);
	
	public List<ServiceSchedule> getBookedScheduleForServiceOnDateForEmployee(long employeeId, long SrviceId, Date date);
	
	public List<ServiceSchedule> getBookedScheduleForServiceOnTimeForEmployee(long employeeId, long SrviceId, Time time);
	
	public List<ServiceSchedule> getBookedScheduleForServiceOnDateTimeSlot(long SrviceId, Date date, Time time);
	
	//public ServiceSchedule saveServiceSchedule(ServiceSchedule serviceSchedule);
	
	//public ServiceSchedule updateServiceSchedule(ServiceSchedule serviceSchedule);
	
	
}
