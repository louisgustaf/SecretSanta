package com.dao.impl;

import javax.persistence.EntityManager;

import com.dao.InterestDao;
import com.dao.PersistenceManager;
import com.model.Interest;

public class InterestDaoImpl extends BaseDaoImpl<Interest> implements InterestDao {
	
	private EntityManager entityManager = PersistenceManager.INSTANCE.getEntityManager();

	@Override
	public Interest getInterestById(int id) {
		return entityManager.find(Interest.class, id);
	}

}
