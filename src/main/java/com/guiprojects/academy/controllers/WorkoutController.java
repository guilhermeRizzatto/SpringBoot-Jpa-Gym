package com.guiprojects.academy.controllers;

import com.guiprojects.academy.dto.request.WorkoutDTORequestPOST;
import com.guiprojects.academy.dto.response.WorkoutDTOResponseBASE;
import com.guiprojects.academy.dto.response.WorkoutDTOResponseFULL;
import com.guiprojects.academy.entities.Workout;
import com.guiprojects.academy.services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/workouts")
public class WorkoutController {
	
	@Autowired
	private WorkoutService workoutService;
	
	@GetMapping(value = "/base/{id}")
	public ResponseEntity<WorkoutDTOResponseBASE> findById(@PathVariable Long id){
		WorkoutDTOResponseBASE obj = new WorkoutDTOResponseBASE(workoutService.findBaseById(id));
		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}
	
	@GetMapping(value = "/full/{id}")
	public ResponseEntity<WorkoutDTOResponseFULL> findByIdFull(@PathVariable Long id){
		WorkoutDTOResponseFULL obj = new WorkoutDTOResponseFULL(workoutService.findFullById(id));
		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}

	@GetMapping
	public ResponseEntity<List<WorkoutDTOResponseBASE>> findAllBase() {
		List<WorkoutDTOResponseBASE> obj = Workout.listWorkoutDTOBase(workoutService.findAll());
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/full")
	public ResponseEntity<List<WorkoutDTOResponseFULL>> findAllFull() {
		List<WorkoutDTOResponseFULL> obj = Workout.listWorkoutDTOFull(workoutService.findAll());
		return ResponseEntity.ok().body(obj);
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
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		workoutService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
