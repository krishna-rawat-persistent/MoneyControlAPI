package com.psl.MoneyControlAPI.Email;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("nancygupta7799@gmail.com");
		message.setTo(sendEmailIds());
		message.setText(body);
		message.setSubject(subject);
		
		
		mailSender.send(message);
		
		System.out.println("Mail Sent Successfully....");
	}

	
	public String[] sendEmailIds() {
		String[] emailIds = new String[2];
		emailIds[0] = "nancygupta426@gmail.com";
		emailIds[1] = "kavitag767@gmail.com";
		return emailIds;
		}
	
	
}
