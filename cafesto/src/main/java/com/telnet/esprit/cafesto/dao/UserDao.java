package com.telnet.esprit.cafesto.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.telnet.esprit.cafesto.entity.User;


@Repository
public class UserDao extends GenericDaoImpl<User> implements GenericDao<User> {

	public UserDao() {
		setClazz(User.class);
	}
	@SuppressWarnings("unchecked")
	public List<User> findByType(String type){
		return getCurrentSession().createQuery("from " + type ).list();
	}
	
	public User authentifiation(String email,String pwd){
		User found = null;
		String jpql="from User u where u.email=:x and u.password=:y";
		Query query =(Query) getCurrentSession().createQuery(jpql);
		query.setParameter("x", email);
		query.setParameter("y", pwd);
		try{
			found=(User) query.getSingleResult();
		}catch (Exception e) {
				Logger.getLogger(User.class.getName()).log(Level.WARNING,"failed authentification :"+ email);
				}
		return found;
	}
	
	public User findUserByMail(String email){
		User found = null;
		String jpql="from User u where u.email=:x";
		Query query =(Query) getCurrentSession().createQuery(jpql);
		query.setParameter("x", email);
		found=(User) query.getSingleResult();
		return found;
		
	}

}
