package com.appointment.schedular.model.tenant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "service_schedular")
public class ServiceSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "service_schedule_id")
	private long serviceScheduleId;

	@ManyToOne(optional = false)
	@JsonBackReference(value = "serviceSchedule-serviceOffered")
	@JoinColumn(name = "service_id")
	private ServicesOffered serviceId;

	@ManyToOne(optional = false)
	@JsonBackReference(value = "serviceSchedule-StaffDetails")
	@JoinColumn(name = "Assigned_staff")
	private StaffDetails staffAssigned;

	@ManyToOne(optional = false)
	@JsonBackReference(value = "serviceSchedule-CustomerDetails")
	@JoinColumn(name = "customer_id")
	private CustomerDetails customerId;

	private DateTime timeSlot;

	private DateTime bookingTime;
	
	@ManyToOne(optional = false)
	@JsonBackReference(value = "serviceSchedule-bookedBy-StaffDetails")
	@JoinColumn(name = "booked_by")
	private StaffDetails bookedBy;

	public long getServiceScheduleId() {
		return serviceScheduleId;
	}

	public void setServiceScheduleId(long serviceScheduleId) {
		this.serviceScheduleId = serviceScheduleId;
	}

	public ServicesOffered getServiceId() {
		return serviceId;
	}

	public void setServiceId(ServicesOffered serviceId) {
		this.serviceId = serviceId;
	}

	public StaffDetails getStaffAssigned() {
		return staffAssigned;
	}

	public void setStaffAssigned(StaffDetails staffAssigned) {
		this.staffAssigned = staffAssigned;
	}

	public CustomerDetails getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomerDetails customerId) {
		this.customerId = customerId;
	}

	public DateTime getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(DateTime timeSlot) {
		this.timeSlot = timeSlot;
	}

	public DateTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(DateTime bookingTime) {
		this.bookingTime = bookingTime;
	}

	public StaffDetails getBookedBy() {
		return bookedBy;
	}

	public void setBookedBy(StaffDetails bookedBy) {
		this.bookedBy = bookedBy;
	}

}
