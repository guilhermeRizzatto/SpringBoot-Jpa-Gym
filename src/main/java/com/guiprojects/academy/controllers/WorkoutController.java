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

import com.guiprojects.academy.dto.request.WorkoutDTORequestPOST;
import com.guiprojects.academy.dto.response.WorkoutDTOResponseBASE;
import com.guiprojects.academy.dto.response.WorkoutDTOResponseFULL;
import com.guiprojects.academy.entities.Workout;
import com.guiprojects.academy.services.WorkoutService;

@RestController
@RequestMapping(value = "/workouts")
public class WorkoutController {
	
	@Autowired
	private WorkoutService workoutService;
	
	@GetMapping(value = "/base/{id}")
	public ResponseEntity<WorkoutDTOResponseBASE> findById(@PathVariable Long id){
		WorkoutDTOResponseBASE obj = new WorkoutDTOResponseBASE(workoutService.findById(id));
		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}
	
	@GetMapping(value = "/full/{id}")
	public ResponseEntity<WorkoutDTOResponseFULL> findByIdFull(@PathVariable Long id){
		WorkoutDTOResponseFULL obj = new WorkoutDTOResponseFULL(workoutService.findById(id));
		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}
	
	
	@PostMapping
	public ResponseEntity<WorkoutDTOResponseBASE> insert(@RequestBody WorkoutDTORequestPOST request){
		Workout obj = new Workout(request);
		WorkoutDTOResponseBASE response = new WorkoutDTOResponseBASE(workoutService.insert(obj));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PatchMapping(value = "/patch/{id}")
	public ResponseEntity<WorkoutDTOResponseBASE> update(@PathVariable Long id, @RequestBody WorkoutDTORequestPOST request){
		Workout obj = new Workout(request);		
		WorkoutDTOResponseBASE response = new WorkoutDTOResponseBASE(workoutService.update(id, obj));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
