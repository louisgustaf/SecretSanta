import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.model.Address;
import com.model.SantaGroup;
import com.model.SecretMember;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class TestClient {

	public static void main(String[] args) throws JsonGenerationException,
			JsonMappingException, IOException {

		SantaGroup santaGroup = new SantaGroup();
		santaGroup.setGroupName("Client group");
		santaGroup.setDescription("etc etc etc etc etc");
		santaGroup.setGiftExchangeDate(new Date());
		santaGroup.setCreationDate(new Date());
		santaGroup.setPriceLimit(500d);

		postSantaGroup(santaGroup);

		putSantaGroup(santaGroup);
		
		SecretMember clientParticipant1 = new SecretMember();
		clientParticipant1.setEmail("clientParticipant1@email.com");
		clientParticipant1.setMemberName("clientParticipant1");
		
		addParticipant(clientParticipant1, santaGroup.getGroupId());
		
		SecretMember clientParticipant2 = new SecretMember();
		clientParticipant2.setEmail("clientParticipant2@email.com");
		clientParticipant2.setMemberName("clientParticipant2");
		
		addParticipant(clientParticipant2,  santaGroup.getGroupId());
		/*
		 * ClientResponse responsePost = webResource.type("application/json")
		 * .post(ClientResponse.class, input);
		 * 
		 * ClientResponse responsePut = webResource.type("application/json")
		 * .put(ClientResponse.class, input);
		 * 
		 * ClientResponse responseDelete = webResource.type("application/json")
		 * .delete(ClientResponse.class, input);
		 */

	}

	private static void postSantaGroup(SantaGroup santaGroup)
			throws JsonGenerationException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		String jsonGroup = mapper.writeValueAsString(santaGroup);
		System.out.println(jsonGroup);

		Client client = Client.create();

		WebResource webResource = client
				.resource("http://localhost:8080/SecretSanta/rest/santagroup");

		ClientResponse responsePost = webResource
				.type(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, jsonGroup);

		if (responsePost.getStatus() != 200 ) {
			throw new RuntimeException("didnt worked");
		}

		SantaGroup santaGroupResponse = mapper.readValue(
				responsePost.getEntity(String.class), SantaGroup.class);
		santaGroup.setGroupId(santaGroupResponse.getGroupId());
	}

	private static void putSantaGroup(SantaGroup santaGroup)
			throws JsonGenerationException, JsonMappingException, IOException {

		Address address = new Address();
		address.setCity("fortaleza");
		address.setCountry("brazil");
		address.setPostalCode("6081025");
		address.setStreet("marlio fernandes");

		santaGroup.setAddress(address);

		ObjectMapper mapper = new ObjectMapper();
		String jsonGroup = mapper.writeValueAsString(santaGroup);
		System.out.println(jsonGroup);

		Client client = Client.create();

		WebResource webResource = client
				.resource("http://localhost:8080/SecretSanta/rest/santagroup");

		ClientResponse responsePost = webResource
				.type(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.put(ClientResponse.class, jsonGroup);

		if (responsePost.getStatus() != 200) {
			throw new RuntimeException("didnt worked");
		}		
	}
	
	private static void addParticipant(SecretMember secretMember, int id) throws JsonParseException, JsonMappingException, ClientHandlerException, UniformInterfaceException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		String jsonMember = mapper.writeValueAsString(secretMember);
		System.out.println(jsonMember);

		Client client = Client.create();

		WebResource webResource = client
				.resource("http://localhost:8080/SecretSanta/rest/santagroup/" + id + "/secretmember");

		ClientResponse responsePost = webResource
				.type(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, jsonMember);

		if (responsePost.getStatus() != 200 ) {
			throw new RuntimeException("didnt worked");
		}

		SecretMember SecretMemberResponse = mapper.readValue(
				responsePost.getEntity(String.class), SecretMember.class);
		secretMember.setSecretId(SecretMemberResponse.getSecretId());
	}
	
}
