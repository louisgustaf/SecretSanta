package com.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.InterestDao;
import com.dao.impl.InterestDaoImpl;
import com.model.Interest;
import com.service.InterestService;

@Path("/interest")
public class InterestServiceImpl implements InterestService{
	
	private InterestDao interestDao = new InterestDaoImpl();

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Interest getInterest(@PathParam("id") int id) {
		return interestDao.getInterestById(id);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public void updateInterest(Interest interest) {
		interestDao.update(interest);
		
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public void addInterest(Interest interest) {
		interestDao.save(interest);
		
	}

	@DELETE
	@Override
	public void removeInterest(@PathParam("id") int id) {
		Interest interest = new Interest();
		interest.setId(id);
		interestDao.delete(interest);
	}

}
