package com.telnet.esprit.cafesto.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EvalutionEstablishment implements Serializable {

	private EvalutionEstablishmentPk pk;
	private Client client;
	private Establishment establishment;

	private int note;
	private String comment;
	private int foodquality;
	private int deliveryService;
	private int homeService;

	public EvalutionEstablishment() {
		// TODO Auto-generated constructor stub
	}

	public EvalutionEstablishment(Client client, Establishment establishment,
			int note, String comment,int foodquality,int deliveryService,int homeService) {
		this.getPk().setIdClient(client.getId());
		this.getPk().setIdEstablishment(establishment.getId());
		this.getPk().setDate(new Date());
		this.client = client;
		this.establishment = establishment;
		this.note = note;
		this.comment = comment;
		this.foodquality=foodquality;
		this.deliveryService=deliveryService;
		this.homeService=homeService;
	}

	@EmbeddedId
	public EvalutionEstablishmentPk getPk() {
		if (pk == null) {
			pk = new EvalutionEstablishmentPk();
		}
		return pk;

	}

	public void setPk(EvalutionEstablishmentPk pk) {
		this.pk = pk;
	}

	@ManyToOne
	@JoinColumn(name = "idClient", insertable = false, updatable = false)
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@ManyToOne
	@JoinColumn(name = "idEstablishment", insertable = false, updatable = false)
	public Establishment getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}

	@Column(nullable=true)
	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	@Column(nullable=true)
	public int getFoodquality() {
		return foodquality;
	}

	public void setFoodquality(int foodquality) {
		this.foodquality = foodquality;
	}
	@Column(nullable=true)
	public int getDeliveryService() {
		return deliveryService;
	}
	
	public void setDeliveryService(int deliveryService) {
		this.deliveryService = deliveryService;
	}
	@Column(nullable=true)
	public int getHomeService() {
		return homeService;
	}

	public void setHomeService(int homeService) {
		this.homeService = homeService;
	}

}
