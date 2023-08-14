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

import com.guiprojects.academy.entities.GymMembership;
import com.guiprojects.academy.services.GymMembershipService;

@RestController
@RequestMapping(value = "/gymMembers")
public class GymMembershipController {

	@Autowired
	private GymMembershipService membershipService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<GymMembership> findById(@PathVariable Long id){
		GymMembership obj = membershipService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<GymMembership> insert(@RequestBody GymMembership member){
		GymMembership obj = membershipService.insert(member);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}
	
}
