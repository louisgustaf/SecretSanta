package com.service.impl;

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

import com.dao.SecretMemberDao;
import com.dao.impl.SecretMemberDaoImpl;
import com.model.Interest;
import com.model.SecretMember;
import com.service.SecretMemberService;

@Path("/secretmember")
public class SecretMemberServiceImpl implements SecretMemberService {
	
	private SecretMemberDao secretMemberDao = new SecretMemberDaoImpl();

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public SecretMember getSecretMemberById( @PathParam("id") int id) {
		return secretMemberDao.getSecretMemberById(id);

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public void updateSecretMember(SecretMember secretMember) {
		secretMemberDao.update(secretMember);
		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public void addSecretMember(SecretMember secretMember) {
		secretMemberDao.save(secretMember);
		
	}

	@DELETE
	@Path("{id}")
	@Override
	public void removeSecretMember(@PathParam("id") int id) {
		SecretMember secretMember = new SecretMember();
		secretMemberDao.delete(secretMember);
	}

	@GET
	@Path("{id}/interests")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Interest> findInterestsOfSecretMember(@PathParam("id") int id) {
		return secretMemberDao.findInterestsOfSecretMember(id);
	}

}
