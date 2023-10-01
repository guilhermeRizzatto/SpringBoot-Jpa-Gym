package com.guiprojects.academy.dto;

import java.util.Set;

import com.guiprojects.academy.entities.Exercise;
import com.guiprojects.academy.entities.Workout;

//Only use in the GymMembershipDTOResponse
//Contain only informations necessary for GymMembership
public class WorkoutDTOGymMembership {
	
	private String description;
	
	private TrainerDTO trainer;
	
	Set<Exercise> exercises;
	
	public WorkoutDTOGymMembership() {
	}

	public WorkoutDTOGymMembership(String description, TrainerDTO trainer, Set<Exercise> exercises) {
		this.description = description;
		this.trainer = trainer;
		this.exercises = exercises;
	}

	public WorkoutDTOGymMembership(Workout obj) {
		super();
		this.description = obj.getDescription();
		this.trainer = new TrainerDTO(obj.getTrainer());
		this.exercises = obj.getExercises();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TrainerDTO getTrainer() {
		return trainer;
	}

	public void setTrainer(TrainerDTO trainer) {
		this.trainer = trainer;
	}

	public Set<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(Set<Exercise> exercises) {
		this.exercises = exercises;
	}
	
	
	
	
	
	

}
