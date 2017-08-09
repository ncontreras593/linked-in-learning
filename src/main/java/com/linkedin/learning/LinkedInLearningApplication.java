package com.linkedin.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * EnableAutoConfiguration annotation intelligently configures beans that
 * we will likely need in our Spring Application Context.  The ComponentScan
 * annotation enables automatic scanning for configuration classes to wire
 * up in the Spring application context.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class LinkedInLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkedInLearningApplication.class, args);
	}
}
