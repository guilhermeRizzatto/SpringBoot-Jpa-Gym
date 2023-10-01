package com.guiprojects.academy.dto;

import java.util.Set;

import com.guiprojects.academy.entities.Exercise;
import com.guiprojects.academy.entities.Workout;

//Only use in the TrainerDTOResponse
//Contain only informations necessary for Trainer
public class WorkoutDTOTrainer {

	private String description;
	private GymMembershipDTOWorkout gymMembership;
	
	Set<Exercise> exercises;
	
	public WorkoutDTOTrainer() {
	}

	public WorkoutDTOTrainer(String description, GymMembershipDTOWorkout gymMembership, Set<Exercise> exercises) {
		this.description = description;
		this.gymMembership = gymMembership;
		this.exercises = exercises;
	}

	public WorkoutDTOTrainer(Workout obj) {
		this.description = obj.getDescription();
		this.gymMembership = new GymMembershipDTOWorkout(obj.getGymMembership());
		this.exercises = obj.getExercises();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public GymMembershipDTOWorkout getGymMembership() {
		return gymMembership;
	}

	public void setGymMembership(GymMembershipDTOWorkout gymMembership) {
		this.gymMembership = gymMembership;
	}

	public Set<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(Set<Exercise> exercises) {
		this.exercises = exercises;
	}
	
	
	
	
	
	
}
