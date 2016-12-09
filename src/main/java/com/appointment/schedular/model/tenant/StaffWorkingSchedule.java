package com.appointment.schedular.model.tenant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "staff_working_schedule")
public class StaffWorkingSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "work_schedule_id")
	private long workScheduleId;
	
	@ManyToOne(optional = false)
	@JsonBackReference(value = "staffWorkingSchedule-staffDetails")
	@JoinColumn(name = "staff_id")
	private StaffDetails staffId;
	
	@Column(name = "day")
	private String Day;
	
	@Column(name = "shift")
	private String shift;
	
	@Column(name = "start_time")
	private String startTime;
	
	@Column(name = "end_time")
	private String endTime;

	public long getWorkScheduleId() {
		return workScheduleId;
	}

	public void setWorkScheduleId(long workScheduleId) {
		this.workScheduleId = workScheduleId;
	}

	public StaffDetails getStaffId() {
		return staffId;
	}

	public void setStaffId(StaffDetails staffId) {
		this.staffId = staffId;
	}

	public String getDay() {
		return Day;
	}

	public void setDay(String day) {
		Day = day;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}
