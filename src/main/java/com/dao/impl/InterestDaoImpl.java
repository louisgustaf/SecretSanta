package com.dao.impl;

import com.dao.InterestDao;
import com.model.Interest;

public class InterestDaoImpl extends BaseDaoImpl<Interest> implements InterestDao {

	@Override
	public Interest getInterestById(int id) {
		return entityManager.find(Interest.class, id);
	}

}
