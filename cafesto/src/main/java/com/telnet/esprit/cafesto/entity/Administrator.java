package com.telnet.esprit.cafesto.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Administrator extends User implements Serializable {

	private List<ServiceProvider> serviceProviders;
	private SuperAdministrator superAdmin;

	
	




	public Administrator(String firstName, String lastName, String adress,
			String tel, byte[] profile, String email, String password,
			String pays, String code, boolean status) {
		super(firstName, lastName, adress, tel, profile, email, password, pays, code,
				status);
		// TODO Auto-generated constructor stub
	}


	public Administrator() {
		// TODO Auto-generated constructor stub
	}
	
	
	@OneToMany(mappedBy="admin")
	@JsonIgnore 
	public List<ServiceProvider> getServiceProviders() {
		return serviceProviders;
	}

	public void setServiceProviders(List<ServiceProvider> serviceProviders) {
		this.serviceProviders = serviceProviders;
	}


	@ManyToOne(cascade=CascadeType.ALL)
	public SuperAdministrator getSuperAdmin() {
		return superAdmin;
	}


	public void setSuperAdmin(SuperAdministrator superAdmin) {
		this.superAdmin = superAdmin;
	}

}
