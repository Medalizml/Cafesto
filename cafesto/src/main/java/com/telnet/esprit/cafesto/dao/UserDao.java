package com.telnet.esprit.cafesto.dao;

import java.util.List;

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

}
