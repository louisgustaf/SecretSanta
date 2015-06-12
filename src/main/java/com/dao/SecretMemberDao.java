package com.dao;

import java.util.List;

import com.model.Interest;
import com.model.SecretMember;

public interface SecretMemberDao extends BaseDao<SecretMember> {

	public SecretMember getSecretMemberById(int id);

	public List<Interest> findInterestsOfSecretMember(int id);

}
