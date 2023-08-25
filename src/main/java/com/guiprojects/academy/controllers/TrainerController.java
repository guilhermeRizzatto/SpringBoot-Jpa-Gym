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


import com.guiprojects.academy.entities.Trainer;
import com.guiprojects.academy.services.TrainerService;

@RestController
@RequestMapping(value = "/trainers")
public class TrainerController {

	@Autowired
	private TrainerService trainerService;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Trainer> findById(@PathVariable Long id){
		Trainer obj = trainerService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@PostMapping
	public ResponseEntity<Trainer> insert(@RequestBody Trainer request){
		request = trainerService.insert(request);	
		return ResponseEntity.status(HttpStatus.CREATED).body(request);
	}
	
	
	
}
