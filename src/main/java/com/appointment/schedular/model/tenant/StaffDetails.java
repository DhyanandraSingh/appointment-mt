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
import javax.persistence.ManyToMany;
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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, 
				  property="staffMemberId")
@Table(name = "staff_details")
public class StaffDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staff_member_id")
	private long staffMemberId;
	
	@NotNull
	@NotEmpty
	@Column(name= "first_name", nullable= false)
	private String firstName;
	
	@NotNull
	@NotEmpty
	@Column(name= "last_name", nullable= false)
	private String lastName;
	
	@Email
	@NotNull
	@NotEmpty
	@Column(name= "email", nullable= false)
	private String email;
	
	@NotNull
	@NotEmpty
	@Column(name= "buisness_contact_no", nullable= false)
	private String buisnessContactNo;
	
	@NotEmpty
	@Column(name= "personal_contact_no")
	private String personalContactNo;
	
	@NotNull
	@NotEmpty
	@Column(name= "gender", nullable= false)
	private String gender;
	
	/*
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name= "houseNo", column= @Column(name ="house_no")),
		@AttributeOverride(name= "street", column= @Column(name ="street")),
		@AttributeOverride(name= "city", column= @Column(name ="city")),
		@AttributeOverride(name= "state", column= @Column(name ="state")),
		@AttributeOverride(name= "country", column= @Column(name ="country")),
		@AttributeOverride(name= "zipCode", column= @Column(name ="zip_code"))
	})
	private StaffAddress address;
	*/
	
	@ElementCollection
	@JoinTable(name = "staff_address", 
			   joinColumns = @JoinColumn(name = "staff_id"))
	@GenericGenerator(name = "sequence-gen", strategy = "sequence")
	@CollectionId(columns = { @Column(name = "address_id") }, 
							  generator = "sequence-gen", 
							  type = @Type(type = "long"))
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Address> listOfAddresses = new ArrayList<Address>();
	
	
	@OneToMany(mappedBy = "staffId",  cascade = CascadeType.ALL)
	@JsonManagedReference(value="staffWorkingSchedule-staffDetails")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<StaffWorkingSchedule> workingSchedule = new ArrayList<>();
	
	@ManyToMany(mappedBy = "linkedStaff", cascade = CascadeType.ALL)
	//@JsonManagedReference(value="serviceOffered-staffDetails")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ServicesOffered> canServe = new ArrayList<ServicesOffered>();
	
	@OneToMany(mappedBy = "staffAssigned",  cascade = CascadeType.ALL)
	@JsonManagedReference(value="serviceSchedule-StaffDetails")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ServiceSchedule> serviceSchedule = new ArrayList<>();
	
	@OneToMany(mappedBy = "bookedBy",  cascade = CascadeType.ALL)
	@JsonManagedReference(value="serviceSchedule-bookedBy-StaffDetails")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ServiceSchedule> serviceSchedulebookedBy = new ArrayList<>();
	
	public List<ServicesOffered> getCanServe() {
		return canServe;
	}

	public void setCanServe(List<ServicesOffered> canServe) {
		this.canServe = canServe;
	}

	public List<ServiceSchedule> getServiceSchedule() {
		return serviceSchedule;
	}

	public void setServiceSchedule(List<ServiceSchedule> serviceSchedule) {
		this.serviceSchedule = serviceSchedule;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getStaffMemberId() {
		return staffMemberId;
	}

	public void setStaffMemberId(long staffMemberId) {
		this.staffMemberId = staffMemberId;
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

	public String getBuisnessContactNo() {
		return buisnessContactNo;
	}

	public void setBuisnessContactNo(String buisnessContactNo) {
		this.buisnessContactNo = buisnessContactNo;
	}

	public String getPersonalContactNo() {
		return personalContactNo;
	}

	public void setPersonalContactNo(String personalContactNo) {
		this.personalContactNo = personalContactNo;
	}

	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}

	public List<StaffWorkingSchedule> getWorkingSchedule() {
		return workingSchedule;
	}

	public void setWorkingSchedule(List<StaffWorkingSchedule> workingSchedule) {
		this.workingSchedule = workingSchedule;
	}
	
	
}
