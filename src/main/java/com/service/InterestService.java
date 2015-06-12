package com.service;

import com.model.Interest;

public interface InterestService {
	
	public Interest getInterest(int id);
	
	public void updateInterest(Interest interest);
	
	public void addInterest(Interest interest);
	
	public void removeInterest(int id);

}
