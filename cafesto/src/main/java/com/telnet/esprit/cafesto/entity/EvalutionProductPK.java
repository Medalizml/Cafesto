package com.telnet.esprit.cafesto.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EvalutionProductPK implements Serializable {
	
	private int idClient;
	private int idProduct;
	private Date date;
	
	public EvalutionProductPK() {
		// TODO Auto-generated constructor stub
	}

	@Column(name="idClient")
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	@Column(name="idProduct")
	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
