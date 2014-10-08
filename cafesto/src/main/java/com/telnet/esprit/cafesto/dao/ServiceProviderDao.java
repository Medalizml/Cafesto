package com.telnet.esprit.cafesto.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.telnet.esprit.cafesto.entity.Establishment;
import com.telnet.esprit.cafesto.entity.EvalutionEstablishment;
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
	
	public List<Establishment> establisementServiceProvide(int idSp){
		List<Establishment> found = null;
		String jpql = "from Establishment u where u.id=:x";
		Query query = (Query) getCurrentSession().createQuery(jpql);
		query.setParameter("x", idSp);

		try {
			found = (List<Establishment>) query.list();
		} catch (Exception e) {

		}
		return found;
	}

}
