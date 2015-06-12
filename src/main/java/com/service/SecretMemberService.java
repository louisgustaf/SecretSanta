package com.service;

import java.util.List;

import com.model.Interest;
import com.model.SecretMember;

public interface SecretMemberService {
	
	public SecretMember getSecretMemberById(int id);
	
	public void updateSecretMember(SecretMember secretMember);
	
	public void addSecretMember(SecretMember secretMember);
	
	public void removeSecretMember(int id);
	
	public List<Interest> findInterestsOfSecretMember(int id);

}
