package com.example.hrady;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HradyApplication {

	public static void main(String[] args) {
		SpringApplication.run(HradyApplication.class, args);
	}

	@GetMapping("/")
	public String listAll() {
		return String.format("aa\nbb\ncc\nHello !");
	}
}
