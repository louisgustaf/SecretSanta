package com.service;

import com.model.SecretMember;

public interface SecretMemberService {
	
	public SecretMember getSecretMember(SecretMember secretMember);
	
	public void updateSecretMember(SecretMember secretMember);
	
	public void addSecretMember(SecretMember secretMember);
	
	public void removeSecretMember(SecretMember secretMember);

}
