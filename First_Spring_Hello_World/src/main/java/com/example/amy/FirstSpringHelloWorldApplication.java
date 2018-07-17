package com.example.amy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.example.controller"})
public class FirstSpringHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringHelloWorldApplication.class, args);
	}
}
