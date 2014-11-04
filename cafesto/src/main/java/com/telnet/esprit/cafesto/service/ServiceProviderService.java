package com.telnet.esprit.cafesto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.telnet.esprit.cafesto.dao.ServiceProviderDao;
import com.telnet.esprit.cafesto.dao.UserDao;
import com.telnet.esprit.cafesto.entity.Establishment;
import com.telnet.esprit.cafesto.entity.EvalutionEstablishment;
import com.telnet.esprit.cafesto.entity.Product;
import com.telnet.esprit.cafesto.entity.ServiceProvider;

@Transactional
@Service
public class ServiceProviderService implements IserviceServiceProvider {

	@Autowired
	ServiceProviderDao dao;

	@Autowired
	UserDao userDao;

	public List<EvalutionEstablishment> ratingEstablishment(int idEstablishment) {
		// TODO Auto-generated method stub
		return dao.RatingServiceProvider(idEstablishment);
	}

	public int nbreNote(int idEstablishment) {
		int nb = 0;
		for (EvalutionEstablishment ev : dao
				.RatingServiceProvider(idEstablishment)) {
			if (ev.getNote() != 0) {
				nb++;
			}
		}
		return nb;
	}

	public float MoyenRating(int idEstablishment) {
		float moy = 0;
		int nb = nbreNote(idEstablishment);
		for (EvalutionEstablishment ev : dao
				.RatingServiceProvider(idEstablishment)) {
			if (ev.getNote() != 0) {
				moy = moy + ev.getNote();
			}
		}
		return (moy / nb);
	}

	public List<Establishment> establisementServiceProvide(int idSp) {
		// TODO Auto-generated method stub

		return dao.establisementServiceProvide((ServiceProvider) userDao
				.find(idSp));

	}

	public Establishment getEstablishmentByServerProvider(int idSp, int idetabl) {

		List<Establishment> establishments = establisementServiceProvide(idSp);
		for (Establishment e : establishments) {
			if (e.getId() == idetabl) {
				return e;
			}

		}
		return null;
	}

	public List<Product> getProduct(int idSp, int idetabl) {
		List<Establishment> establishments = establisementServiceProvide(idSp);
		for (Establishment e : establishments) {
			if (e.getId() == idetabl) {
				return dao.getProduct(e);
			}

		}
		return null;
	}

}
