package com.service;

import com.model.SantaGroup;

public interface SecretSantaService {
	
	public void assignSecretMembers(SantaGroup santaGroup);
	
	public void sendEmailMessafe(SantaGroup santaGroup);
	
}
