package com.example.portalspolecznosciowy;

import com.example.portalspolecznosciowy.models.User;
import com.example.portalspolecznosciowy.repositories.PhotosRepository;
import com.example.portalspolecznosciowy.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PortalspolecznosciowyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalspolecznosciowyApplication.class, args);
	}
	@Bean
	public CommandLineRunner instagramexample(UserRepository userRepository) {
		return args -> {
			User user = new User("Galan","Daniel","Partyka","dp@wp.pl","12345");
			userRepository.save(user);
		};
	}
}
