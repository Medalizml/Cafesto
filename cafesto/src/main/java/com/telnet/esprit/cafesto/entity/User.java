package com.telnet.esprit.cafesto.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User  implements Serializable{
	
	int id;
	private String firstName ;
	private String lastName;
	private String adress ;
	private String tel ;
	private byte[] profile ;
	private String email;
	private String password;
	private boolean status;
	private String pays;
	private String code;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	public User(String firstName, String lastName, String adress, String tel,
			byte[] profile, String email, String password,String pays,String code,boolean status) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.tel = tel;
		this.profile = profile;
		this.email = email;
		this.password = password;
		this.pays=pays;
		this.code=code;
		this.status=status;
	}


	@Id    
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(columnDefinition="LONGBLOB")
	public byte[] getProfile() {
		return profile;
	}

	public void setProfile(byte[] profile) {
		this.profile = profile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	

}
