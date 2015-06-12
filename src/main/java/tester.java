import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.dao.PersistenceManager;
import com.model.Address;
import com.model.Interest;
import com.model.SantaGroup;
import com.model.SecretMember;

public class tester {
	
	public static void main(String[] args) {
		Address address = new Address();
		address.setCity("Dhaka");
		address.setCountry("Bangladesh");
		address.setPostalCode("1000");
		address.setStreet("Poribagh");
		
		Interest interest1 = new Interest();
		interest1.setDescription("books");
		Interest interest2 = new Interest();
		interest2.setDescription("movies");
		
		
		SecretMember particapant1 = new SecretMember();
		particapant1.setEmail("participant1@email.com");
		particapant1.setMemberName("participant1");
		
		SecretMember particapant2 = new SecretMember();
		particapant2.setEmail("participant2@email.com");
		particapant2.setMemberName("participant2");
		
		SantaGroup santaGroup = new SantaGroup();
		santaGroup.setGroupName("test group");
		santaGroup.setDescription("bla bla bla bla bla");
		santaGroup.setGiftExchangeDate(new Date());
		santaGroup.setCreationDate(new Date());
		santaGroup.setPriceLimit(100d);
		santaGroup.setAddress(address);
	
		

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(santaGroup);
		em.flush();
		
		particapant1.setSantaGroup(santaGroup);
		particapant2.setSantaGroup(santaGroup);
		
		
		List<SecretMember> participants = new ArrayList<SecretMember>();
		participants.add(particapant1);
		participants.add(particapant2);
		
		santaGroup.setParticipant(participants);
		
		em.flush();
		
		List<Interest> interests = new ArrayList<Interest>();

		em.merge(santaGroup);
		
		interest1.setSecretMember(particapant1);
		interest2.setSecretMember(particapant2);
		
		interests.add(interest1);
		interests.add(interest2);
		
		particapant1.setInterests(interests);
				
		particapant2.setInterests(interests);
			
		em.flush();

		em.merge(santaGroup);
		
		em.getTransaction().commit();

		em.close();
		PersistenceManager.INSTANCE.close();
	}
}
