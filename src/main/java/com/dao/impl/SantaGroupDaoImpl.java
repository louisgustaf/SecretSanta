package com.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.dao.PersistenceManager;
import com.dao.SantaGroupDao;
import com.model.SantaGroup;
import com.model.SecretMember;

public class SantaGroupDaoImpl extends BaseDaoImpl<SantaGroup> implements SantaGroupDao{
	
	private EntityManager entityManager = PersistenceManager.INSTANCE.getEntityManager();

	@Override
	public SantaGroup getSantaGroupById(int id) {
		return entityManager.find(SantaGroup.class, id);
	}
	
	@Override
	public List<SantaGroup> listAllSantaGroups() {
		String s = "SELECT s FROM SantaGroup s";
        Query query = entityManager.createQuery(s);
        
        return query.getResultList();
	}

	@Override
	public List<SecretMember> listSecretMembersOfSantaGroup(int id) {
		String s = "SELECT s FROM SecretMember s where s.santaGroup.id = :id";
        
		Query query = entityManager.createQuery(s);
        query.setParameter("id", id);
        
		return query.getResultList();
	}
	

}
