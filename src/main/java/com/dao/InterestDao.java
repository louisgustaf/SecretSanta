package com.dao;

import com.model.Interest;

public interface InterestDao extends BaseDao<Interest> {

	Interest getInterestById(int id);

}
