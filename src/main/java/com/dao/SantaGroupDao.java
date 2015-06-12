package com.dao;

import java.util.List;

import com.model.SantaGroup;
import com.model.SecretMember;

public interface SantaGroupDao extends BaseDao<SantaGroup> {
	
	public SantaGroup getSantaGroupById(int id);

	public List<SantaGroup> listAllSantaGroups();

	public List<SecretMember> listSecretMembersOfSantaGroup(int id);

}
