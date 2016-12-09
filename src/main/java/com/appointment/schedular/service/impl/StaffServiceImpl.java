/**
 * 
 */
package com.appointment.schedular.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appointment.schedular.dao.tenant.StaffDao;
import com.appointment.schedular.dao.tenant.StaffWorkingScheduleDao;
import com.appointment.schedular.model.tenant.StaffDetails;
import com.appointment.schedular.model.tenant.StaffWorkingSchedule;
import com.appointment.schedular.service.StaffService;

/**
 * @author Dhyanandra
 *
 */

@Service("StaffServiceImpl")
@Transactional
public class StaffServiceImpl implements StaffService{
	
	@Autowired
	StaffDao staffDao;
	
	@Autowired
	StaffWorkingScheduleDao staffWorkingSchedule;
	
	@Override
	public List<StaffDetails> fetchAllStaff() {
		return staffDao.fetchAllStaff();
	}

	@Override
	public StaffDetails fetchStaffById(long staffId) {
		return staffDao.fetchStaffById(staffId);
	}

	@Override
	public StaffDetails saveStaffDetails(StaffDetails staffDetails) {
		return staffDao.saveStaffDetails(staffDetails);
	}

	@Override
	public StaffDetails updateStaff(long staffId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaffDetails deleteStaff(long staffId) {
		// TODO Auto-generated method stub
		return null;
	}

	/** Address **/
	@Override
	public List<StaffDetails> fetchAddressDetails(long staffId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StaffDetails> updateAddress(long addressId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StaffDetails> deleteAddress(long staffId) {
		// TODO Auto-generated method stub
		return null;
	}

	/** working schedule **/
	@Override
	public List<StaffWorkingSchedule> fetchworkingSchedule(long staffId) {
		return staffWorkingSchedule.getStaffWorkingSchedule(staffId);
	}

	@Override
	public List<StaffWorkingSchedule> updateworkingSchedule(long workScheduleId) {
		return null;
	}

	@Override
	public List<StaffWorkingSchedule> deleteworkingSchedule(long workScheduleId) {
		return null;
	}

}
