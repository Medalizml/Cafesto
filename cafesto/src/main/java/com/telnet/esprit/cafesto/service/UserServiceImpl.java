package com.telnet.esprit.cafesto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.telnet.esprit.cafesto.dao.GenericDao;
import com.telnet.esprit.cafesto.dao.UserDao;
import com.telnet.esprit.cafesto.entity.ServiceProvider;
import com.telnet.esprit.cafesto.entity.User;

@Service
@Transactional
public class UserServiceImpl implements Iservice<User> {

	@Autowired
	private UserDao dao;

	public void create(User u) {
		dao.create(u);
	}

	public User Authentication(String email, String password) {

		return dao.authentifiation(email, password);

	}

	public List<User> findAll() {
		System.out.println(dao.findAll());
		return dao.findAll();
	}

	public User findByid(int id) {
		return dao.find(id);
	}

	public GenericDao<User> getDao() {
		return dao;
	}

	public List<User> findBytype(String type) {
		return dao.findByType(type);
	}

	public void update(User u) {
		dao.update(u);
	}

	public void remove(User u) {
		dao.delete(u);

	}

	public boolean findbyMail(String mail) {
		// TODO Auto-generated method stub
		return dao.findUserByMail(mail);
	}

	public List<ServiceProvider> findbyAdmin(int id) {
	
		return dao.findbyAdministrator(id);
	}

}
