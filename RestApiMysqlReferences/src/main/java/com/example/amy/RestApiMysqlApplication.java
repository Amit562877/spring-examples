package com.example.amy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages= {"com.example.controller,com.example.service"})
@EntityScan("com.example.model")
@EnableJpaRepositories("com.example.repository")
public class RestApiMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiMysqlApplication.class, args);
	}
}
