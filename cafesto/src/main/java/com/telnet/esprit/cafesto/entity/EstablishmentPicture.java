package com.telnet.esprit.cafesto.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class EstablishmentPicture implements Serializable {

	private int id;
	private byte[] picture;
	private Establishment establishmentpic;

	public EstablishmentPicture() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Lob
	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="establishmentId")
	public Establishment getEstablishmentpic() {
		return establishmentpic;
	}

	public void setEstablishmentpic(Establishment establishmentpic) {
		this.establishmentpic = establishmentpic;
	}

	
	

}
