package com.guiprojects.academy.controllers;

import com.guiprojects.academy.dto.request.RegistrationDTORequest;
import com.guiprojects.academy.dto.response.RegistrationDTOResponse;
import com.guiprojects.academy.entities.Registration;
import com.guiprojects.academy.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

	@GetMapping
	public ResponseEntity<List<RegistrationDTOResponse>> findAll() {
		List<RegistrationDTOResponse> obj = Registration.listRegistration(registrationService.findAll());
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<RegistrationDTOResponse> insert(@RequestBody RegistrationDTORequest registration){
		Registration obj = new Registration(registration);
		RegistrationDTOResponse response = new RegistrationDTOResponse(registrationService.insert(obj));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PatchMapping(value = "/patch/{id}")
	public ResponseEntity<RegistrationDTOResponse> update(@PathVariable Long id, @RequestBody RegistrationDTORequest registration){
		Registration obj = Registration.auxiliary(registration);
		RegistrationDTOResponse response = new RegistrationDTOResponse(registrationService.update(id, obj));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
}
