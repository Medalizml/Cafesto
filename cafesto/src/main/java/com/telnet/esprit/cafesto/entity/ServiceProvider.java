package com.telnet.esprit.cafesto.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ServiceProvider extends User implements Serializable {

	private String nameProvider;
	private Administrator admin;
	private List<Establishment> establishments;

	
	

	

	public ServiceProvider(String firstName, String lastName, String adress,
			String tel, byte[] profile, String email, String password,
			String pays, String code, boolean status ,String nameProvider) {
		super(firstName, lastName, adress, tel, profile, email, password, pays, code,
				status);
		this.nameProvider= nameProvider;
		// TODO Auto-generated constructor stub
	}

	public ServiceProvider() {
		// TODO Auto-generated constructor stub
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	public Administrator getAdmin() {
		return admin;
	}

	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}

	@OneToMany(mappedBy = "seProvider")
	@JsonIgnore
	public List<Establishment> getEstablishments() {
		return establishments;
	}

	public void setEstablishments(List<Establishment> establishments) {
		this.establishments = establishments;
	}

	public String getNameProvider() {
		return nameProvider;
	}

	public void setNameProvider(String nameProvider) {
		this.nameProvider = nameProvider;
	}

}
