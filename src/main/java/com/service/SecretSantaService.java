package com.service;

import com.model.SantaGroup;

public interface SecretSantaService {
	
	public void assignSecretMembers(SantaGroup santaGroup);
	
	public void sendEmailMessage(String message);
	
}
