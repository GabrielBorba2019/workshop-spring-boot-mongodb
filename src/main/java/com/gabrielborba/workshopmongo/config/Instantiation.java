package com.gabrielborba.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gabrielborba.workshopmongo.domain.Post;
import com.gabrielborba.workshopmongo.domain.User;
import com.gabrielborba.workshopmongo.dto.AuthorDTO;
import com.gabrielborba.workshopmongo.repository.PostRepository;
import com.gabrielborba.workshopmongo.repository.UserRepository;

@Configuration //Anotation de Config (Dar um reset na base de dados)
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		//Salvando usuários no mongoDB
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Pualo. Abraços!", new AuthorDTO( maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO( maria));
		
		
		
		
		//Salvando post no mongoDB
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
