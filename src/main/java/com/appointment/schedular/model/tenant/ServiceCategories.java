package com.appointment.schedular.model.tenant;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "service_categories")
public class ServiceCategories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "service_category_id")
	private long serviceCatId;
	
	@NotNull
	@NotEmpty
	@Column(name="service_category_name", nullable=false)
	private String serviceCatName;
	
	@NotEmpty
	@Column(name="description")
	private String serviceCatDescription;
	
	@OneToMany(mappedBy = "serviceCategories",  cascade = CascadeType.ALL)
	@JsonManagedReference(value="ServiceOffered-ServiceCategories")
	@LazyCollection(LazyCollectionOption.FALSE)
	//@JsonIgnore
	private List<ServicesOffered> service = new ArrayList<>();

	public long getServiceCatId() {
		return serviceCatId;
	}

	public void setServiceCatId(long serviceCatId) {
		this.serviceCatId = serviceCatId;
	}

	public String getServiceCatName() {
		return serviceCatName;
	}

	public void setServiceCatName(String serviceCatName) {
		this.serviceCatName = serviceCatName;
	}


	public String getServiceCatDescription() {
		return serviceCatDescription;
	}

	public void setServiceCatDescription(String serviceCatDescription) {
		this.serviceCatDescription = serviceCatDescription;
	}

	public List<ServicesOffered> getService() {
		return service;
	}

	public void setService(List<ServicesOffered> service) {
		this.service = service;
	}
	
}
