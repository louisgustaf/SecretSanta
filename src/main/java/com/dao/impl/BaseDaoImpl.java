package com.dao.impl;

import com.dao.BaseDao;
import com.dao.PersistenceManager;

public class BaseDaoImpl<Entity> implements BaseDao<Entity>{

	@Override
	public void save(Entity entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		PersistenceManager.INSTANCE.close();
		
	}

	@Override
	public void update(Entity entity) {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		PersistenceManager.INSTANCE.close();
	}

	@Override
	public void delete(Entity entity) {
		entityManager.getTransaction().begin();
		entityManager.remove(entity);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		PersistenceManager.INSTANCE.close();
		
	}

}
