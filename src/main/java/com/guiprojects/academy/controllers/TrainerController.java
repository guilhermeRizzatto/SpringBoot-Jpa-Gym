package com.guiprojects.academy.controllers;

import com.guiprojects.academy.dto.request.TrainerDTORequest;
import com.guiprojects.academy.dto.response.TrainerDTOBaseResponse;
import com.guiprojects.academy.dto.response.TrainerDTOResponse;
import com.guiprojects.academy.entities.Trainer;
import com.guiprojects.academy.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	public ResponseEntity<TrainerDTOResponse> findByIdFull(@PathVariable Long id){
		TrainerDTOResponse obj = TrainerDTOResponse.createExercises(trainerService.findFullById(id));
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<TrainerDTOBaseResponse>> findAllBase() {
		List<TrainerDTOBaseResponse> obj = Trainer.listTrainerDTOBase(trainerService.findAll());
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/full")
	public ResponseEntity<List<TrainerDTOResponse>> findAllFull() {
		List<TrainerDTOResponse> obj = Trainer.listTrainerDTOFull(trainerService.findAllFull());
		return ResponseEntity.ok().body(obj);
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
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		trainerService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	
}
