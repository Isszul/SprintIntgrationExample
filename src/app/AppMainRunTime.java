package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageHandler;
import org.springframework.integration.support.MessageBuilder;

import app.domain.Person;

public class AppMainRunTime {

	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
	
		ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
		
		DirectChannel inputChannel = (DirectChannel) context.getBean("inputChannel");
		DirectChannel outputChannel = (DirectChannel) context.getBean("outputChannel");
			    
	    outputChannel.subscribe(new MessageHandler(){

			public void handleMessage(Message<?> personMessage)
			{
				Person person = (Person) personMessage.getPayload();
				System.out.println("Person Recieved : " + person.getName());
				
			};
	    	
	    });

	    
	    Message<String> message = MessageBuilder.withPayload("hello").build();
	    inputChannel.send(message);	    
	    
		
		
	}
	
	
}
