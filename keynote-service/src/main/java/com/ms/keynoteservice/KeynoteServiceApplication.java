package com.ms.keynoteservice;

import com.ms.keynoteservice.entity.Keynote;
import com.ms.keynoteservice.repository.KeynoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KeynoteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeynoteServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner c(KeynoteRepository keynoteRepository) {
        return args -> {
            for (int i = 0; i < 10; i++) {
                Keynote keynote = new Keynote(null,"keynote "+i,"idk","keynote"+i+"@gmail.com","func"+i);
                keynoteRepository.save(keynote);
            }
        };
    }

}
