package com.telnet.esprit.cafesto.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Commande implements Serializable {
	
	private CommandePk pk;
	
	private Client commandeClient;
	private Table table;
	private Product product;
	private int nbrPersonne ;
	private String adresse ;
	private String type;
	
	public Commande() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Commande(Client commandeClient, Table table, Product product,
			int nbrPersonne, String adresse, String type) {
		this.getPk().setIdClient(commandeClient.getId());
		this.getPk().setIdProduct(product.getId());
		this.commandeClient = commandeClient;
		this.product = product;
		this.nbrPersonne = nbrPersonne;
		this.adresse = adresse;
		this.type = type;
	}


	

	@EmbeddedId
	public CommandePk getPk() {
		if(pk==null){
			pk=new CommandePk();
		}
		return pk;
	}



	public void setPk(CommandePk pk) {
		this.pk = pk;
	}



	@ManyToOne
	@JoinColumn(name = "idClient", insertable = false, updatable = false)
	public Client getCommandeClient() {
		return commandeClient;
	}

	public void setCommandeClient(Client commandeClient) {
		this.commandeClient = commandeClient;
	}

	
	@ManyToOne(cascade=CascadeType.ALL)
	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	@ManyToOne
	@JoinColumn(name = "idProduct", insertable = false, updatable = false)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getNbrPersonne() {
		return nbrPersonne;
	}

	public void setNbrPersonne(int nbrPersonne) {
		this.nbrPersonne = nbrPersonne;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
