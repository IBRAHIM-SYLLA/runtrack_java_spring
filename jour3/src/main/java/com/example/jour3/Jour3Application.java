package com.example.jour3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ComponentScan(basePackages = "com.example.*")
public class Jour3Application {

	public static void main(String[] args) {
		SpringApplication.run(Jour3Application.class, args);
	}

}
