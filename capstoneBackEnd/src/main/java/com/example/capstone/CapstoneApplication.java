package com.example.capstone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.capstone.entity.User;
import com.example.capstone.repo.UserRepo;
@CrossOrigin
@SpringBootApplication
@EntityScan(basePackages = "com.example.capstone.entity")
public class CapstoneApplication implements CommandLineRunner{
	
	@Autowired
	UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(CapstoneApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		User user= new User("rachna","123");
		userRepo.save(user);
		
	}

}
