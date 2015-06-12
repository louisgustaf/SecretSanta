package com.service;

import java.util.List;

import com.model.SantaGroup;
import com.model.SecretMember;

public interface SantaGroupService {
	
	public SantaGroup getSantaGroupById(int id);
	
	public List<SantaGroup> listAllSantaGroups();
	
	public List<SecretMember> listSecretMembersOfSantaGroups(int id);
	
	public SantaGroup updateSantaGroup(SantaGroup santaGroup);
	
	public SantaGroup addSantaGroup(SantaGroup santaGroup);
	
	public void removeSantaGroup(int id);
	
	public SecretMember addParticipantToGroup(int id, SecretMember secretMember);

}
