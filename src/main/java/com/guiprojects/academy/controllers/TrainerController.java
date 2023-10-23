package com.guiprojects.academy.controllers;

import java.util.Set;

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

import com.guiprojects.academy.dto.request.TrainerDTORequest;
import com.guiprojects.academy.dto.response.TrainerDTOBaseResponse;
import com.guiprojects.academy.dto.response.TrainerDTOResponse;
import com.guiprojects.academy.entities.Trainer;
import com.guiprojects.academy.services.TrainerService;

@RestController
@RequestMapping(value = "/trainers")
public class TrainerController {

	@Autowired
	private TrainerService trainerService;
	
	
	@GetMapping(value = "/base/{id}")
	public ResponseEntity<TrainerDTOBaseResponse> findById(@PathVariable Long id){
		TrainerDTOBaseResponse obj = new TrainerDTOBaseResponse(trainerService.findById(id));
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/full/{id}")
	public ResponseEntity<Set<TrainerDTOResponse>> findByIdFull(@PathVariable Long id){
		Set<TrainerDTOResponse> list = TrainerDTOResponse.createExercises(trainerService.findFullById(id));
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<TrainerDTOBaseResponse> insert(@RequestBody TrainerDTORequest request){
		Trainer obj = new Trainer(request);	
		TrainerDTOBaseResponse response = new TrainerDTOBaseResponse(trainerService.insert(obj));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PatchMapping(value = "/patch/{id}")
	public ResponseEntity<TrainerDTOBaseResponse> update(@PathVariable Long id, @RequestBody TrainerDTORequest request){
		Trainer obj = new Trainer(request);		
		TrainerDTOBaseResponse response = new TrainerDTOBaseResponse(trainerService.update(id, obj));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	
}
