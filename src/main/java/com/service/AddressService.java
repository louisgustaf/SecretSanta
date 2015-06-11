package com.service;

import com.model.Address;
import com.model.SantaGroup;

public interface AddressService {
	
	public Address getAddress(SantaGroup santaGroup);
	
	public Address updateAddress(SantaGroup santaGroup);
	
	public Address addAddress(SantaGroup santaGroup);
	
	public Address removeAddress(SantaGroup santaGroup);
	
}
