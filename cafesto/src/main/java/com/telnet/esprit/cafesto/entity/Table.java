package com.telnet.esprit.cafesto.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="t_table")
public class Table implements Serializable {

	private int id;
	private int number;
	private String status;

	private Establishment establishment;

	private List<Commande> commandes;

	public Table() {
		// TODO Auto-generated constructor stub
	}

	public Table(int id, int number, String status) {

		this.id = id;
		this.number = number;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public Establishment getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}

	@OneToMany(mappedBy = "table")
	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

}
