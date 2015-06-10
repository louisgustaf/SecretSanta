package com.dao;

import com.model.Address;

public interface AddressDao extends BaseDao<Address>{
	
	public Address findById(String deviceId);
	
	public Address findByGroup(String deviceId);

}
