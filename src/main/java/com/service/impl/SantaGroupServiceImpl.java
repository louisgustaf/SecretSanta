package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.SantaGroupDao;
import com.dao.impl.SantaGroupDaoImpl;
import com.model.SantaGroup;
import com.model.SecretMember;
import com.service.SantaGroupService;

@Path("/santagroup")
public class SantaGroupServiceImpl implements SantaGroupService {
	
	private SantaGroupDao santaGroupDao = new SantaGroupDaoImpl();

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public SantaGroup updateSantaGroup(SantaGroup santaGroup) {
		santaGroupDao.update(santaGroup);
		return santaGroup;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public SantaGroup addSantaGroup(SantaGroup santaGroup) {
		santaGroupDao.save(santaGroup);
		return santaGroup;
	}

	@DELETE
	@Path("{id}")
	@Override
	public void removeSantaGroup(@PathParam("id")int id) {
		SantaGroup santaGroup = new SantaGroup();
		santaGroup.setGroupId(id);
		santaGroupDao.delete(santaGroup);
		
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public SantaGroup getSantaGroupById(@PathParam("id") int id) {
		SantaGroup santaGroup = new SantaGroup();
		santaGroup.setGroupId(id);
		return santaGroupDao.getSantaGroupById(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	@Override
	public List<SantaGroup> listAllSantaGroups() {
		return santaGroupDao.listAllSantaGroups();
	}

	@GET
	@Path("{id}/secretmembers")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<SecretMember> listSecretMembersOfSantaGroups(@PathParam("id") int id) {
		return santaGroupDao.listSecretMembersOfSantaGroup(id);
	}

	@POST
	@Path("{id}/secretmember")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public SecretMember addParticipantToGroup(@PathParam("id") int id, SecretMember secretMember) {
		SantaGroup santaGroup = santaGroupDao.getSantaGroupById(id);
		secretMember.setSantaGroup(santaGroup);
		if(santaGroup.getMembers() == null){
			List<SecretMember> secretMembers = new ArrayList<SecretMember>();
			secretMembers.add(secretMember);
			santaGroup.setMembers(secretMembers);
		}else{
			santaGroup.getMembers().add(secretMember);
		}
		
		
		santaGroupDao.update(santaGroup);
		
		return secretMember;
	}

}
