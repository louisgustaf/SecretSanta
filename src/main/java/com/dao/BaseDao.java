package com.dao;

import javax.persistence.EntityManager;

public interface BaseDao<Entity>{
	
	EntityManager entityManager = PersistenceManager.INSTANCE.getEntityManager();
	
	public void save(Entity entity);

    public void update(Entity entity);

    public void delete(Entity entity);
    
}
