package com.ritubrata.springbootstarter;

/**
 * @SpringBootApplication encapsulates @Configuration, @EnableAutoConfiguration, and @ComponentScan 
 * annotations with their default attributes.
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApiApp {
	
	public static void main(String[] args) {
		SpringApplication.run(CourseApiApp.class, args);
	}

}
