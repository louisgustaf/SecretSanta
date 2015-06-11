package com.service;

import com.model.Interest;
import com.model.SecretMember;

public interface InterestService {
	
	public Interest getInterest(SecretMember secretMember);
	
	public void updateInterest(SecretMember secretMember);
	
	public void addInterest(SecretMember secretMember);
	
	public void removeInterest(SecretMember secretMember);

}
