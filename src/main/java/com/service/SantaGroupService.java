package com.service;

import com.model.SantaGroup;

public interface SantaGroupService {
	
	public SantaGroup getSantaGroup(SantaGroup santaGroup);
	
	public void updateSantaGroup(SantaGroup santaGroup);
	
	public void addSantaGroup(SantaGroup santaGroup);
	
	public void removeSantaGroup(SantaGroup santaGroup);

}
