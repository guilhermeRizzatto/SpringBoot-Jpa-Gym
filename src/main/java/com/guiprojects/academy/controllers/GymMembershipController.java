package com.guiprojects.academy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guiprojects.academy.dto.request.GymMembershipDTORequest;
import com.guiprojects.academy.dto.response.GymMembershipDTOBaseResponse;
import com.guiprojects.academy.dto.response.GymMembershipDTOResponse;
import com.guiprojects.academy.entities.GymMembership;
import com.guiprojects.academy.services.GymMembershipService;


@RestController
@RequestMapping(value = "/gymMembers")
public class GymMembershipController {

	@Autowired
	private GymMembershipService membershipService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<GymMembershipDTOBaseResponse> findById(@PathVariable Long id){
		GymMembershipDTOBaseResponse obj = new GymMembershipDTOBaseResponse(membershipService.findById(id));
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<GymMembershipDTOBaseResponse>> findAll() {
		List<GymMembershipDTOBaseResponse> obj = GymMembership.listMembersDTOBase(membershipService.findAll());
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/withWorkout")
	public ResponseEntity<List<GymMembershipDTOResponse>> findAllWithWorkout() {
		List<GymMembershipDTOResponse> obj = GymMembership.listMembersDTOFull(membershipService.findAllWithWorkout());
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/withWorkout/{id}")
	public ResponseEntity<GymMembershipDTOResponse> findByIdWithWorkout(@PathVariable Long id){
		GymMembershipDTOResponse obj = new GymMembershipDTOResponse(membershipService.findFullById(id));
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<GymMembershipDTOBaseResponse> insert(@RequestBody GymMembershipDTORequest request){
		GymMembership obj = new GymMembership(request);		
		GymMembershipDTOBaseResponse response = new GymMembershipDTOBaseResponse(membershipService.insert(obj));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PatchMapping(value = "/patch/{id}")
	public ResponseEntity<GymMembershipDTOBaseResponse> update(@PathVariable Long id, @RequestBody GymMembershipDTORequest request){
		GymMembership obj = new GymMembership(request);		
		GymMembershipDTOBaseResponse response = new GymMembershipDTOBaseResponse(membershipService.update(id, obj));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		membershipService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
