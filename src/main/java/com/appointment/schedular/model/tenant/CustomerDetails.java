package com.appointment.schedular.model.tenant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customer_details")
public class CustomerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private long customerId;
	
	@NotNull
	@NotEmpty
	@Column(name= "first_name", nullable= false)
	private String firstName;
	
	@NotNull
	@NotEmpty
	@Column(name= "last_name", nullable= false)
	private String lastName;
	
	@Email
	@Column(name= "email")
	private String email;
	
	@NotNull
	@NotEmpty
	@Column(name= "contact_no", nullable= false)
	private String contactNo;
	
	@ElementCollection
	@JoinTable(name = "customer_address", 
			   joinColumns = @JoinColumn(name = "customer_id"))
	@GenericGenerator(name = "sequence-gen", strategy = "sequence")
	@CollectionId(columns = { @Column(name = "address_id") }, 
				  generator = "sequence-gen", 
				  type = @Type(type = "long"))
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Address> listOfAddresses = new ArrayList<Address>();
	
	@OneToMany(mappedBy = "customerId",  cascade = CascadeType.ALL)
	@JsonManagedReference(value="serviceSchedule-CustomerDetails")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ServiceSchedule> serviceSchedule = new ArrayList<>();
	

	public List<ServiceSchedule> getServiceSchedule() {
		return serviceSchedule;
	}

	public void setServiceSchedule(List<ServiceSchedule> serviceSchedule) {
		this.serviceSchedule = serviceSchedule;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
}
