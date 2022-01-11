package com.offDesk.offdeskproject;

import com.offDesk.offdeskproject.Service.ServiceImpl.MailCommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class OffdeskprojectApplication {

	@Autowired
	private MailCommunicationService mailCommunicationService;

	public static void main(String[] args) {
		SpringApplication.run(OffdeskprojectApplication.class, args);

	}
		@EventListener(ApplicationReadyEvent.class)
		public void sendMail ()
		{
			System.out.println("THIS IS MY Main Entry Class ");
			mailCommunicationService.mailSend("mansoori9399@gmail.com", "this is my first mail", "forsick leave today i am not well");
			System.out.println("THIS IS MY Main Class ");
		}


}
