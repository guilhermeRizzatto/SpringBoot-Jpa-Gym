package com.guiprojects.academy.dto.request;

import com.guiprojects.academy.entities.GymMembership;
import com.guiprojects.academy.entities.Trainer;

//Only use in POST method in the Controller
public class WorkoutDTORequestPOST {
	
	private Long id;
	private String description;
	private GymMembership gymMembership;
	
	private Trainer trainer;
	

	public WorkoutDTORequestPOST() {
	}

	public WorkoutDTORequestPOST(Long id, String description, GymMembership gymMembership, Trainer trainer) {
		this.id = id;
		this.description = description;
		this.gymMembership = gymMembership;
		this.trainer = trainer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public GymMembership getGymMembership() {
		return gymMembership;
	}

	public void setGymMembership(GymMembership gymMembership) {
		this.gymMembership = gymMembership;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

}
