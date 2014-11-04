package com.telnet.esprit.cafesto.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product implements Serializable{
	private int id ;
	private String name;
	private String description;
	private String price;
	private byte[] photo;
	private Establishment establishment;
	
	private List<EvalutionProduct> evalutionProducts ;
	private List<Commande>commandes;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String name, String description, String price) {
		
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	public Establishment getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}

	@Lob
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@OneToMany(mappedBy="product")
	@JsonIgnore
	public List<EvalutionProduct> getEvalutionProducts() {
		return evalutionProducts;
	}

	public void setEvalutionProducts(List<EvalutionProduct> evalutionProducts) {
		this.evalutionProducts = evalutionProducts;
	}

	@OneToMany(mappedBy="product")
	@JsonIgnore
	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
	
}
