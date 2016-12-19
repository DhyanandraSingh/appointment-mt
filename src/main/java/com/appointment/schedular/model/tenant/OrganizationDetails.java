package com.appointment.schedular.model.tenant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "organization_details")
public class OrganizationDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "organization_id" )
	private long organizationId;
	
	@NotNull
	@NotEmpty
	@Column( name = "name", nullable= false )
	private String name;
	
	/*
		@NotNull
		@NotEmpty
		@Column( name = "name", nullable= false )
		private String industry;
	*/	
	
	@Column( name = "time_zone", nullable= false )
	private String timeZone;
	
	@Column( name = "currency", nullable= false )
	private String currency;
	
	public String getName() {
		return name;
	}

	public long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	
		public String getIndustry() {
			return industry;
		}
	
		public void setIndustry(String industry) {
			this.industry = industry;
		}

	*/
		
	public String getTimeZone() {
		return timeZone;
	}
	
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
