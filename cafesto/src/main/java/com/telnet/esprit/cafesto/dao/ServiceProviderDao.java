package com.telnet.esprit.cafesto.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.telnet.esprit.cafesto.entity.Establishment;
import com.telnet.esprit.cafesto.entity.EvalutionEstablishment;
import com.telnet.esprit.cafesto.entity.Product;
import com.telnet.esprit.cafesto.entity.ServiceProvider;

@Repository
public class ServiceProviderDao extends GenericDaoImpl<ServiceProvider>
		implements GenericDao<ServiceProvider> {

	public ServiceProviderDao() {
		setClazz(ServiceProvider.class);
	}

	public List<EvalutionEstablishment> RatingServiceProvider(int idEtablisment) {
		List<EvalutionEstablishment> found = null;
		String jpql = "from EvalutionEstablishment u where u.idEstablishment=:x";
		Query query = (Query) getCurrentSession().createQuery(jpql);
		query.setParameter("x", idEtablisment);

		try {
			found = (List<EvalutionEstablishment>) query.list();
		} catch (Exception e) {

		}
		return found;
	}

	public List<Establishment> establisementServiceProvide(ServiceProvider s) {
		List<Establishment> found = null;
		String jpql = "from Establishment u where u.seProvider=:x";
		Query query = (Query) getCurrentSession().createQuery(jpql);
		query.setParameter("x", s);

		try {
			found = (List<Establishment>) query.list();
		} catch (Exception e) {

		}
		return found;
	}

	public Establishment getEtablishmentByServiceProvider(Establishment e,
			ServiceProvider s) {
		Establishment found = null;
		String jpql = "from Establishment u where u.seProvider=:x and u:=y)";
		Query query = (Query) getCurrentSession().createQuery(jpql);
		query.setParameter("x", s);
		query.setParameter("y", e);

		try {
			found = (Establishment) query.uniqueResult();
		} catch (Exception e1) {

		}
		return found;
	}
	public List<Product> getProduct(Establishment e){
		List<Product> products = null;
		String jpql = "from Product u where u.establishment=:x)";
		Query query = (Query) getCurrentSession().createQuery(jpql);
		query.setParameter("x", e);

		try {
			products = (List<Product>) query.list();
		} catch (Exception e1) {

		}
		
		return products;
		
	}

}
