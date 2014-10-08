package com.telnet.esprit.cafesto.service;

import java.util.List;

import com.telnet.esprit.cafesto.entity.Establishment;
import com.telnet.esprit.cafesto.entity.EvalutionEstablishment;

public interface IserviceServiceProvider {
	
	public List<EvalutionEstablishment> ratingEstablishment(int idEstablishment);
	public int nbreNote(int idEstablishment);
	public float MoyenRating(int idEstablishment);
	public List<Establishment> establisementServiceProvide(int idSp);
	
}
