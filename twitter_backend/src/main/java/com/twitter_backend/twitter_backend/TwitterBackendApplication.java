package com.twitter_backend.twitter_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.twitter_backend.twitter_backend.repositorys")
@ComponentScan(basePackages = { "com.twitter_backend.twitter_backend.mappers" })
@EntityScan("com.twitter_backend.twitter_backend.models")  
@SpringBootApplication
public class TwitterBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterBackendApplication.class, args);
	}

}
