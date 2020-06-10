package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repository.UserRepository;

@SpringBootTest
class UserHandlerTest {
	@Autowired
	private UserRepository userRepository;
	
	@Test
	void findAll() {
		System.out.println(userRepository.findAll());
	}
}
