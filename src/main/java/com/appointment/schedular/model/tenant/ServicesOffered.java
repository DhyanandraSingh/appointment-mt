package com.appointment.schedular.model.tenant;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="serviceId")
@Table(name = "service_offered")
public class ServicesOffered {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_id")
	private long serviceId;

	@NotNull
	@NotEmpty
	@Column(name = "service_name", nullable = false)
	private String serviceName;

	@NotEmpty
	@Column(name = "description")
	private String description;

	@Column(name = "service_duration")
	private java.sql.Time serviceDuration;

	@Column(name = "buffer_duration")
	private java.sql.Time bufferDuration;

	@ManyToOne(optional = false)
	@JsonBackReference(value = "ServiceOffered-ServiceCategories")
	@JoinColumn(name = "service_category_id")
	private ServiceCategories serviceCategories;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "service_agents", 
			   joinColumns = { @JoinColumn(name = "service_id") }, 
			   inverseJoinColumns = { @JoinColumn(name = "staff_id") })
	//@JsonBackReference(value="serviceOffered-staffDetails")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<StaffDetails> linkedStaff = new ArrayList<StaffDetails>();

	@OneToMany(mappedBy = "serviceId", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "serviceSchedule-serviceOffered")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ServiceSchedule> serviceSchedule = new ArrayList<>();

	public List<StaffDetails> getLinkedStaff() {
		return linkedStaff;
	}

	public void setLinkedStaff(List<StaffDetails> linkedStaff) {
		this.linkedStaff = linkedStaff;
	}

	public List<ServiceSchedule> getServiceSchedule() {
		return serviceSchedule;
	}

	public void setServiceSchedule(List<ServiceSchedule> serviceSchedule) {
		this.serviceSchedule = serviceSchedule;
	}

	public long getServiceId() {
		return serviceId;
	}

	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public java.sql.Time getServiceDuration() {
		return serviceDuration;
	}

	public void setServiceDuration(java.sql.Time serviceDuration) {
		this.serviceDuration = serviceDuration;
	}

	public java.sql.Time getBufferDuration() {
		return bufferDuration;
	}

	public void setBufferDuration(java.sql.Time bufferDuration) {
		this.bufferDuration = bufferDuration;
	}

	public ServiceCategories getServiceCategories() {
		return serviceCategories;
	}

	public void setServiceCategories(ServiceCategories serviceCategories) {
		this.serviceCategories = serviceCategories;
	}

}
