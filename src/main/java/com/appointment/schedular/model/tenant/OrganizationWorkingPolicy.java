package com.appointment.schedular.model.tenant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "working_policy")
public class OrganizationWorkingPolicy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "policy_id")
	private long policyId;
	
	@NotEmpty
	@NotNull
	@Column(name= "day")
	private String day;
	
	//@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalTime")
	//@DateTimeFormat(pattern="hh:mm:ss" /* iso = ISO.TIME */)
	//@Temporal(TemporalType.TIME)
	@Column(name = "start_time")
	private java.sql.Time startTime;
	
	//@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalTime")
	//@DateTimeFormat(pattern="HH:mm:ss" /* iso = ISO.TIME */)
	//@Temporal(TemporalType.TIME)
	@Column(name = "end_time")
	private java.sql.Time endTime;
	
	public long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(long policyId) {
		this.policyId = policyId;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public java.sql.Time getStartTime() {
		return startTime;
	}

	public void setStartTime(java.sql.Time startTime) {
		this.startTime = startTime;
	}

	public java.sql.Time getEndTime() {
		return endTime;
	}

	public void setEndTime(java.sql.Time endTime) {
		this.endTime = endTime;
	}
}
