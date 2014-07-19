package com.telnet.esprit.cafesto.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SuperAdministrator extends User implements Serializable {
	
	List<Administrator> administrators;
	
	public SuperAdministrator() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public SuperAdministrator(String firstName, String lastName, String adress,
			String tel, byte[] profile, String email, String password) {
		super(firstName, lastName, adress, tel, profile, email, password);
		
	}

	@OneToMany(mappedBy="superAdmin")
	 @JsonIgnore  
	public List<Administrator> getAdministrators() {
		return administrators;
	}

	public void setAdministrators(List<Administrator> administrators) {
		this.administrators = administrators;
	}
	

}
