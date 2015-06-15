package com.dao.impl;

import javax.persistence.EntityManager;

import com.dao.BaseDao;
import com.dao.PersistenceManager;

public class BaseDaoImpl<Entity> implements BaseDao<Entity> {

	private PersistenceManager persistenceManager = PersistenceManager.INSTANCE;

	private EntityManager entityManager;

	@Override
	public void save(Entity entity) {
		try {
			entityManager = persistenceManager.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.flush();
			entityManager.getTransaction().commit();
		} catch (RuntimeException re) {
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void update(Entity entity) {
		try {
			entityManager = persistenceManager.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.flush();
			entityManager.getTransaction().commit();
		} catch (RuntimeException re) {
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}

	}

	@Override
	public void delete(Entity entity) {
		try {
			entityManager = persistenceManager.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
		} catch (RuntimeException re) {
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
	}
	
}
