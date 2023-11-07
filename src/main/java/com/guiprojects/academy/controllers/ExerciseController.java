package com.guiprojects.academy.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guiprojects.academy.dto.request.ExerciseDTORequest;
import com.guiprojects.academy.dto.response.ExerciseDTOResponse;
import com.guiprojects.academy.entities.Exercise;
import com.guiprojects.academy.services.ExerciseService;

@RestController
@RequestMapping(value = "/exercises")
public class ExerciseController {
	
	@Autowired
	private ExerciseService exerciseService;
	
	@GetMapping(value = "/byWorkout/{id}")
	public ResponseEntity<Set<ExerciseDTOResponse>> findById(@PathVariable Long id){
		Set<ExerciseDTOResponse> list = ExerciseDTOResponse.createExercises(exerciseService.findByWorkoutId(id));
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@PostMapping
	public ResponseEntity<ExerciseDTOResponse> insert(@RequestBody ExerciseDTORequest request){
		Exercise obj = new Exercise(request);
		ExerciseDTOResponse response = new ExerciseDTOResponse(exerciseService.insert(obj));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PatchMapping(value = "/patch/workout/{workoutId}/exerciseType/{exerciseTypeId}")
	public ResponseEntity<ExerciseDTOResponse> update(@PathVariable Long workoutId, @PathVariable Long exerciseTypeId, @RequestBody ExerciseDTORequest request){
		Exercise obj = new Exercise(request);		
		ExerciseDTOResponse response = new ExerciseDTOResponse(exerciseService.update(workoutId, exerciseTypeId, obj));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping(value = "/delete/workout/{workoutId}/exerciseType/{exerciseTypeId}")
	public ResponseEntity<Void> delete(@PathVariable Long workoutId, @PathVariable Long exerciseTypeId){
		exerciseService.delete(workoutId, exerciseTypeId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
