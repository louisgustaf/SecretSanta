package com.dao;


public interface BaseDao<Entity>{
	
	public void save(Entity entity);

    public void update(Entity entity);

    public void delete(Entity entity);
    
}
