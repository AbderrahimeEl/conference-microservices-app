package com.ms.authservice;

import com.ms.authservice.entity.User;
import com.ms.authservice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthServiceApplication {
	private final PasswordEncoder passwordEncoder;

    public AuthServiceApplication(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepository userRepository) {
		return args -> {
			if (userRepository.findByName("hamid").isEmpty()) {
				User user = new User();
				user.setName("hamid");
				user.setPassword(passwordEncoder.encode("hamid"));
				userRepository.save(user);
				System.out.println("Default user 'john' created with password '1234'");
			}
		};
	}

}
