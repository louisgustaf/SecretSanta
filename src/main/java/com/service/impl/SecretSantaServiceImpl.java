package com.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.model.SantaGroup;
import com.model.SecretMember;
import com.service.SecretSantaService;

@Path("/secretsanta")
public class SecretSantaServiceImpl implements SecretSantaService{

	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public void assignSecretMembers(SantaGroup santaGroup) {
		
	}

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Override
	public void sendEmailMessage(String Message) {
		// TODO Auto-generated method stub
		
	}
	
	private void assign(SantaGroup santaGroup){
		List<SecretMember> secretMembers =  santaGroup.getMembers();
		List<SecretMember> secretMembersCpy = new ArrayList<SecretMember>();
		
		Collections.copy(secretMembers, secretMembersCpy);
		String secretSanta = null;
		
		Random  random = new Random();
		
		for(SecretMember sm : secretMembers){
			
			int rnd = random.nextInt(secretMembersCpy.size());
			secretSanta = secretMembersCpy.get(rnd).getMemberName();
			
			if(sm.getMemberName().equals(secretSanta)){
				if(secretMembersCpy.size() == 1){
					SecretMember tempScret = secretMembers.get(random.nextInt(secretMembers.size() - 1));
					sm.setSecretSanta(tempScret.getSecretSanta());
					tempScret.setSecretSanta(secretMembersCpy.get(0).getSecretSanta());
				} else{
					SecretMember temp = secretMembersCpy.remove(rnd);
					rnd = random.nextInt(secretMembersCpy.size());
					secretSanta = secretMembersCpy.get(rnd).getMemberName();
					secretMembersCpy.remove(rnd);
					secretMembersCpy.add(temp);
				}
			} else{
				sm.setSecretSanta(secretSanta);		
			}
		}
	}
	
	private void sendAssigmentMessage(List<SecretMember> members){
		//TODO
	}

}
