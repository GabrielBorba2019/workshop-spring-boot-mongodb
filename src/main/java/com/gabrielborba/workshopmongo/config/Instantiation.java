package com.gabrielborba.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gabrielborba.workshopmongo.domain.User;
import com.gabrielborba.workshopmongo.repository.UserRepository;

@Configuration //Anotation de Config
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		
		//Salvando usuários no mongoDB
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
	}

}
