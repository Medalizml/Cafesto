package com.telnet.esprit.cafesto.service;

import java.io.Serializable;
import java.util.List;

import com.telnet.esprit.cafesto.entity.User;

public interface Iservice<U extends Serializable> {
	
	public void create(U u);
	public void update(U u);
	public List<U> findAll();
	public U findByid(int id);
	public List<U> findBytype(String type);
	public void remove(U u);
	public User Authentication(String email, String password);
	
	public U findbyMail(String mail);
	
}
