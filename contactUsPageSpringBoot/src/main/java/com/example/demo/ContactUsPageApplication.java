package com.example.demo;

import com.example.demo.repository.UserRepositoryInterface;
import com.example.demo.serivice.UserService;
import com.example.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactUsPageApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ContactUsPageApplication.class, args);
	}

	@Autowired
	private UserRepositoryInterface userRepositoryInterface;
	@Override
	public void run(String... args) throws Exception {
		User s1 = new User("Aryan","as@gmail.com");
		userRepositoryInterface.save(s1);

	}
}
