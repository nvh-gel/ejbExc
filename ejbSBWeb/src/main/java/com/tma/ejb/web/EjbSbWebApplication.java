package com.tma.ejb.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class EjbSbWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjbSbWebApplication.class, args);
	}
}

@RestController
class HelloController {
	@RequestMapping("/")
	String hello() {
		return "Hi " + " !";

	}
}