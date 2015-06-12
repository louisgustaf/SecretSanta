package com.dao.impl;

import com.dao.BaseDao;

public class BaseDaoImpl<Entity> implements BaseDao<Entity>{

	@Override
	public void save(Entity entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.flush();
		entityManager.getTransaction().commit();
		
	}

	@Override
	public void update(Entity entity) {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.flush();
		entityManager.getTransaction().commit();
		

	}

	@Override
	public void delete(Entity entity) {
		entityManager.getTransaction().begin();
		entityManager.remove(entity);
		entityManager.getTransaction().commit();
	}

}
