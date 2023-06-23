package com.moreAdvanceMailSender.User1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmailAdvance(String eamailString) {
		Random random = new Random();
		String r = String.valueOf(random.nextInt(0,1000));
		SimpleMailMessage sMessage = new SimpleMailMessage();
		sMessage.setTo(eamailString);
		sMessage.setSubject("Authentication");
		sMessage.setText(r);
		sMessage.setFrom("aryangolbaghi@gmail.com");
		createUser(eamailString,r);
		javaMailSender.send(sMessage);
	}

	public void createUser(String username, String pin) {
		userRepository.save(new User(username,pin));
	}

	public boolean checkAuthentication(String value) {
		User user = userRepository.findByPin(value);
		return user != null;
	}
}