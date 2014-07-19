package com.telnet.esprit.cafesto.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EvalutionEstablishmentPk implements Serializable {
	
	private int idClient;
	private int idEstablishment;
	private Date date;
	
	public EvalutionEstablishmentPk() {
		// TODO Auto-generated constructor stub
	}
	
	public EvalutionEstablishmentPk(int idClient, int idEstablishment) {
		
		this.idClient = idClient;
		this.idEstablishment = idEstablishment;
	}

	@Column(name = "idClient")
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	@Column(name = "idEstablishment")
	public int getIdEstablishment() {
		return idEstablishment;
	}
	public void setIdEstablishment(int idEstablishment) {
		this.idEstablishment = idEstablishment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + idClient;
		result = prime * result + idEstablishment;
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
		EvalutionEstablishmentPk other = (EvalutionEstablishmentPk) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (idClient != other.idClient)
			return false;
		if (idEstablishment != other.idEstablishment)
			return false;
		return true;
	}
	
	

	

}
