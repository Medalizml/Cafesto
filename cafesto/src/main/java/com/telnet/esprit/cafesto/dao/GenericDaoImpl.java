package com.telnet.esprit.cafesto.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class GenericDaoImpl<T extends Serializable> implements
		GenericDao<T> {

	private Class<T> clazz;

	@Autowired
	SessionFactory sessionFactory;

	public void setClazz(final Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	@SuppressWarnings("unchecked")
	public T find(int id) {

		return (T) this.getCurrentSession().get(this.clazz.getName(), id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {

		return this.getCurrentSession()
				.createQuery("from " + this.clazz.getName()).list();

	}

	public void create(T t) {
		System.out.println(t);
		this.getCurrentSession().save(t);
	}

	public void update(T t) {

		getCurrentSession().update(t);
	}

	public void delete(final T entity) {

		this.getCurrentSession().delete(entity);
	}

	public void deleteById(int id) {
		final T entity = this.find(id);
		this.delete(entity);
	}

	protected final Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
}