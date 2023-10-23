package com.guiprojects.academy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guiprojects.academy.dto.request.RegistrationDTORequest;
import com.guiprojects.academy.dto.response.RegistrationDTOResponse;
import com.guiprojects.academy.entities.Registration;
import com.guiprojects.academy.services.RegistrationService;

@RestController
@RequestMapping(value = "/registrations")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<RegistrationDTOResponse> findById(@PathVariable Long id){
		RegistrationDTOResponse registration = new RegistrationDTOResponse(registrationService.findById(id));
		return ResponseEntity.ok().body(registration);
	}
	
	@PostMapping
	public ResponseEntity<RegistrationDTOResponse> insert(@RequestBody RegistrationDTORequest registration){
		Registration obj = new Registration(registration);
		RegistrationDTOResponse response = new RegistrationDTOResponse(registrationService.insert(obj));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PatchMapping(value = "/patch/{id}")
	public ResponseEntity<RegistrationDTOResponse> update(@PathVariable Long id, @RequestBody RegistrationDTORequest registration){
		Registration obj = new Registration(registration);		
		RegistrationDTOResponse response = new RegistrationDTOResponse(registrationService.update(id, obj));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
