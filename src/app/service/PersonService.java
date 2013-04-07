package app.service;

import org.springframework.integration.Message;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

import app.domain.Person;

//@MessageEndpoint
@Service
public class PersonService {

	//@ServiceActivator(inputChannel = "inputChannel", outputChannel = "outputChannel")
	public Person processMessage(Message<String> message)
	{
		Person person = new Person();
		person.setAddress("address");
		person.setName((String) message.getPayload());
		
		return person;
	}

}
