package com.guiprojects.academy;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AcademyApplication {
	
	

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		SpringApplication.run(AcademyApplication.class, args);
	}

}
