/**
 * 
 */
package com.appointment.schedular.dao.tenant;

import java.util.List;

import com.appointment.schedular.model.tenant.StaffWorkingSchedule;

/**
 * @author Dhyanandra
 *
 */
public interface StaffWorkingScheduleDao {

	//public List<StaffWorkingSchedule> saveWorkingSchedule(long staffId );
	
	public String deleteWorkingSchedule(long workScheduleId);
	
	public StaffWorkingSchedule updateWorkingSchedule(long workScheduleId, 
			                                          StaffWorkingSchedule workSchedule);
	
	public List<StaffWorkingSchedule> getStaffWorkingSchedule(long staffId);
	
	public List<StaffWorkingSchedule> getStaffWorkingScheduleOfDay(long staffId, String day);
	
}
