package com.guiprojects.academy.controllers;

import com.guiprojects.academy.dto.request.WorkLoadDTORequest;
import com.guiprojects.academy.dto.response.WorkLoadDTOResponse;
import com.guiprojects.academy.entities.WorkLoad;
import com.guiprojects.academy.services.WorkLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/workLoads")
public class WorkLoadController {

	@Autowired
	private WorkLoadService workLoadService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<WorkLoadDTOResponse> findById(@PathVariable Long id){
		WorkLoadDTOResponse obj = new WorkLoadDTOResponse(workLoadService.findById(id));
		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}

	@GetMapping
	public ResponseEntity<List<WorkLoadDTOResponse>> findAll() {
		List<WorkLoadDTOResponse> obj = WorkLoad.listWorkLoad(workLoadService.findAll());
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<WorkLoadDTOResponse> insert(@RequestBody WorkLoadDTORequest request){
		WorkLoad obj = new WorkLoad(request);
		WorkLoadDTOResponse response = new WorkLoadDTOResponse(workLoadService.insert(obj));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PatchMapping(value = "/patch/{id}")
	public ResponseEntity<WorkLoadDTOResponse> update(@PathVariable Long id, @RequestBody WorkLoadDTORequest request){
		WorkLoad obj = new WorkLoad(request);		
		WorkLoadDTOResponse response = new WorkLoadDTOResponse(workLoadService.update(id, obj));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
}
