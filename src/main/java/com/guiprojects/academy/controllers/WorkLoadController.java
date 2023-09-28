package com.guiprojects.academy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guiprojects.academy.dto.request.WorkLoadDTORequest;
import com.guiprojects.academy.entities.WorkLoad;
import com.guiprojects.academy.entities.enums.WeekDays;
import com.guiprojects.academy.services.WorkLoadService;

@RestController
@RequestMapping(value = "/workLoads")
public class WorkLoadController {

	@Autowired
	private WorkLoadService service;
	
	@PostMapping
	public ResponseEntity<WorkLoadDTORequest> insert(@RequestBody WorkLoadDTORequest request){
		WorkLoad obj = new WorkLoad(request);		
		WorkLoadDTORequest response = new WorkLoadDTORequest(service.insert(obj));
		for(WeekDays x : obj.getDays()) {
			System.out.println(x);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	
	
}
