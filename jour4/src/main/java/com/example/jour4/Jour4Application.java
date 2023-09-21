package com.example.jour4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ComponentScan(basePackages = "com.example.*")
public class Jour4Application {

	public static void main(String[] args) {
		SpringApplication.run(Jour4Application.class, args);
	}

}
