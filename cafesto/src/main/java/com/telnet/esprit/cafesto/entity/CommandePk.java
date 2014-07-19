package com.telnet.esprit.cafesto.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CommandePk implements Serializable{
	
	private int idClient;
	private int idProduct;

	
	public CommandePk() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idClient;
		result = prime * result + idProduct;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommandePk other = (CommandePk) obj;
		if (idClient != other.idClient)
			return false;
		if (idProduct != other.idProduct)
			return false;
		return true;
	}

	
	
	

}
