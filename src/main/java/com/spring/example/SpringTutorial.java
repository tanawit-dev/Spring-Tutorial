package com.spring.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

//@EnableScheduling
@EntityScan("com.spring.example.model")
@EnableJpaRepositories("com.spring.example.repository")
@SpringBootApplication
public class SpringTutorial {
    public static void main(String[] args) {
        SpringApplication.run(SpringTutorial.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
