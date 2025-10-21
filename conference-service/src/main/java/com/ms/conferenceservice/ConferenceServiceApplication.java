package com.ms.conferenceservice;

import com.ms.conferenceservice.entity.Conference;
import com.ms.conferenceservice.entity.Review;
import com.ms.conferenceservice.repository.ConferenceRepository;
import com.ms.conferenceservice.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.Instant;


@SpringBootApplication
@EnableFeignClients

public class ConferenceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConferenceServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ReviewRepository reviewRepository, ConferenceRepository conferenceRepository) {
		return args -> {
			for(int j=0; j<10; j++) {
				Conference c = new Conference(null,"c"+j, Instant.now(), 12.4,45.2,10,(long) j);
				conferenceRepository.save(c);
				for (int i = 0; i < 10; i++) {
					reviewRepository.
							save(new Review(null, Instant.now(), "conference zwina tbarkllah", 2, c));
				}
			}
		};
	}
}
