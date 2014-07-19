package com.telnet.esprit.cafesto.service;

import java.io.Serializable;
import java.util.List;

public interface Iservice<U extends Serializable> {
	
	public void create(U u);
	public void update(U u);
	public List<U> findAll();
	public U findByid(int id);
	public List<U> findBytype(String type);
	public void remove(U u);
	
}
