package com.telnet.esprit.cafesto.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Client extends User implements Serializable {
	
	private List<EvalutionEstablishment> clientEvalutions;
	
	private List<EvalutionProduct> evalutionProductsClients;
	
	private List<Commande> commandeClients;
	
	
		
	public Client() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	




	public Client(String firstName, String lastName, String adress, String tel,
			byte[] profile, String email, String password, String pays,
			String code, boolean status) {
		super(firstName, lastName, adress, tel, profile, email, password, pays, code,
				status);
		// TODO Auto-generated constructor stub
	}









	@OneToMany(mappedBy="client")
	public List<EvalutionEstablishment> getClientEvalutions() {
		return clientEvalutions;
	}

	public void setClientEvalutions(List<EvalutionEstablishment> clientEvalutions) {
		this.clientEvalutions = clientEvalutions;
	}

	
	@OneToMany(mappedBy="evclient")
	public List<EvalutionProduct> getEvalutionProductsClients() {
		return evalutionProductsClients;
	}

	public void setEvalutionProductsClients(List<EvalutionProduct> evalutionProductsClients) {
		this.evalutionProductsClients = evalutionProductsClients;
	}

	@OneToMany(mappedBy="commandeClient")
	public List<Commande> getCommandeClients() {
		return commandeClients;
	}

	public void setCommandeClients(List<Commande> commandeClients) {
		this.commandeClients = commandeClients;
	}
	
	
}
