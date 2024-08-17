package com.spring.angularbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication(scanBasePackages = "com.spring.angularbackend")
@CrossOrigin(origins = "http://localhost:4200")
public class AngularbackendApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(AngularbackendApplication.class, args);
		System.out.println("Application running");

	}
}
