package com.guiprojects.academy.dto.request;

import java.util.Set;

import com.guiprojects.academy.entities.Exercise;
import com.guiprojects.academy.entities.GymMembership;
import com.guiprojects.academy.entities.Trainer;

//Only use in PUT method in the Controller
public class WorkoutDTORequestPUT {
	
	private Long id;
	private String description;
	private GymMembership gymMembership;
	
	private Trainer trainer;
	
	private Set<Exercise> exercises;
	
	public WorkoutDTORequestPUT() {
	}

	public WorkoutDTORequestPUT(Long id, String description, GymMembership gymMembership, Trainer trainer, Set<Exercise> exercises) {
		this.id = id;
		this.description = description;
		this.gymMembership = gymMembership;
		this.trainer = trainer;
		this.exercises = exercises;
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

	public Set<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(Set<Exercise> exercises) {
		this.exercises = exercises;
	}
	
	
	
	

}
