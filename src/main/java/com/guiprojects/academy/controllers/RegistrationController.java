package com.guiprojects.academy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guiprojects.academy.entities.Registration;
import com.guiprojects.academy.services.RegistrationService;

@RestController
@RequestMapping(value = "/registrations")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Registration> findById(@PathVariable Long id){
		Registration registration = registrationService.findById(id);
		return ResponseEntity.ok().body(registration);
	}
	
	@PostMapping
	public ResponseEntity<Registration> insert(@RequestBody Registration registration){
		Registration obj = registrationService.insert(registration);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}
}
