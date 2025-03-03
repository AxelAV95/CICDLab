package com.example.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SimpleAppCicdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleAppCicdApplication.class, args);
	}
	
	@GetMapping("/hello")
    public String hello() {
        return "¡Hola desde Spring Boot!";
    }

}
