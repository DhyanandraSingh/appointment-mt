package com.appointment.schedular.dao.master;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Dhyanandra
 *
 */
public abstract class AbstractMasterDao<PK extends Serializable, T> {

	private final Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractMasterDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	@PersistenceContext(unitName="masterEntityManager")
    private EntityManager entityManager;
	
	protected EntityManager getSession() {
		return this.entityManager;
	 }

	public T getByKey(PK key) {
		return (T) getSession().find(persistentClass, key);
	}

	public void persist(Object entity) {
		getSession().persist(entity);
	}

	public T save(T entity) {
		getSession().persist(entity);
		return entity;
	}

	public void delete(T entity) {
		getSession().remove(entity);
	}
	
	public void update(T entity){
		getSession().merge(entity);
	}

	protected Criteria createEntityCriteria() {
		Session session = entityManager.unwrap(Session.class);
		return session.createCriteria(persistentClass);
	}

}
