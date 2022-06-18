package com.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})
public class GestionLaboApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionLaboApplication.class, args);
	}

}
