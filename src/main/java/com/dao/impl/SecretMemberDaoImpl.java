package com.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.dao.PersistenceManager;
import com.dao.SecretMemberDao;
import com.model.Interest;
import com.model.SecretMember;

public class SecretMemberDaoImpl extends BaseDaoImpl<SecretMember> implements SecretMemberDao {
	
	private EntityManager entityManager = PersistenceManager.INSTANCE.getEntityManager();

	@Override
	public SecretMember getSecretMemberById(int id) {
		return entityManager.find(SecretMember.class, id);
	}

	@Override
	public List<Interest> findInterestsOfSecretMember(int id) {
		
		String s = "SELECT i FROM Interest i where i.secretMember.id = :id";
        
		Query query = entityManager.createQuery(s);
        query.setParameter("id", id);
        
		return query.getResultList();
	}

}
