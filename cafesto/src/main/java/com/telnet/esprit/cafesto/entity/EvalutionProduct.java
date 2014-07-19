package com.telnet.esprit.cafesto.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EvalutionProduct implements Serializable {
	
	private EvalutionProductPK pk;
	private Client evclient;
	private Product product;
	
	private int note;
	private String comment;

	public EvalutionProduct() {
		// TODO Auto-generated constructor stub
	}
	
	public EvalutionProduct(Client evclient, Product product, int note,
			String comment) {
		this.pk.setDate(new Date());
		this.pk.setIdClient(evclient.getId());
		this.pk.setIdProduct(product.getId());
		this.evclient = evclient;
		this.product = product;
		this.note = note;
		this.comment = comment;
	}

	@EmbeddedId
	public EvalutionProductPK getPk() {
		if(pk==null){
			pk= new EvalutionProductPK();
		}
		return pk;
	}

	public void setPk(EvalutionProductPK pk) {
		this.pk = pk;
	}

	@ManyToOne
	@JoinColumn(name = "idClient", insertable = false, updatable = false)
	public Client getEvclient() {
		return evclient;
	}

	public void setEvclient(Client evclient) {
		this.evclient = evclient;
	}

	@ManyToOne
	@JoinColumn(name = "idProduct", insertable = false, updatable = false)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

}
