package com.example.demoAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * To load classes using the @Component annotation in Java modules (vendor, common modules) into the context
 *
 * Package information must be specified in scanBasePackages of @SpringBootApplication.
 */

@SpringBootApplication(scanBasePackages = {"com.example.demoAPI.api.*"})
@EnableScheduling
public class DemoApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApiApplication.class, args);
	}

}
