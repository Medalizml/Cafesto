package com.telnet.esprit.cafesto.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;


public interface GenericDao<T extends Serializable> {
	void create(T t);

	T find(int id);

	void update(T t);

	List<T> findAll();

	void deleteById(int id);
}