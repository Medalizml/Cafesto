package com.telnet.esprit.cafesto.service;

import java.util.List;

import com.telnet.esprit.cafesto.entity.Establishment;
import com.telnet.esprit.cafesto.entity.EvalutionEstablishment;
import com.telnet.esprit.cafesto.entity.Product;

public interface IserviceServiceProvider {
	
	public List<EvalutionEstablishment> ratingEstablishment(int idEstablishment);
	public int nbreNote(int idEstablishment);
	public float MoyenRating(int idEstablishment);
	public List<Establishment> establisementServiceProvide(int idSp);
	public Establishment getEstablishmentByServerProvider(int idSp,int idetabl);
	public List<Product> getProduct(int idSp, int idetabl);
}
