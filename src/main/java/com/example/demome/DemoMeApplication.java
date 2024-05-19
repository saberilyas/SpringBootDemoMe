package com.example.demome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class DemoMeApplication {

	public DemoMeApplication() {
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoMeApplication.class, args);
	}

	@GetMapping({"/afficher"})
	String afficher() {
		return "Ma premiere application Springboot";
	}
}
