package com.guiprojects.academy.controllers;

import com.guiprojects.academy.dto.request.ExerciseTypeDTORequest;
import com.guiprojects.academy.dto.response.ExerciseTypeDTOResponse;
import com.guiprojects.academy.entities.ExerciseType;
import com.guiprojects.academy.services.ExerciseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/exerciseTypes")
public class ExerciseTypeController {

	@Autowired
	private ExerciseTypeService exerciseTypeService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ExerciseTypeDTOResponse> findById(@PathVariable Long id){
		ExerciseTypeDTOResponse obj = new ExerciseTypeDTOResponse(exerciseTypeService.findById(id));
		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}

	@GetMapping
	public ResponseEntity<List<ExerciseTypeDTOResponse>> findAll() {
		List<ExerciseTypeDTOResponse> obj = ExerciseType.listExerciseType(exerciseTypeService.findAll());
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<ExerciseTypeDTOResponse> insert(@RequestBody ExerciseTypeDTORequest request){
		ExerciseType obj = new ExerciseType(request);
		ExerciseTypeDTOResponse response = new ExerciseTypeDTOResponse(exerciseTypeService.insert(obj));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PatchMapping(value = "/patch/{id}")
	public ResponseEntity<ExerciseTypeDTOResponse> update(@PathVariable Long id, @RequestBody ExerciseTypeDTORequest request){
		ExerciseType obj = new ExerciseType(request);		
		ExerciseTypeDTOResponse response = new ExerciseTypeDTOResponse(exerciseTypeService.update(id, obj));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		exerciseTypeService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
