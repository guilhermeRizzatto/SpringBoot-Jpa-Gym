package com.guiprojects.academy.dtoAuxiliary;

import com.guiprojects.academy.entities.Workout;

//Only use in the TrainerDTOResponse
//Contain only informations necessary for Trainer
public class WorkoutDTOTrainer {

	private String description;
	private GymMembershipDTOWorkout gymMembership;
	
	
	public WorkoutDTOTrainer() {
	}

	public WorkoutDTOTrainer(String description, GymMembershipDTOWorkout gymMembership) {
		this.description = description;
		this.gymMembership = gymMembership;
	}

	public WorkoutDTOTrainer(Workout obj) {
		this.description = obj.getDescription();
		this.gymMembership = new GymMembershipDTOWorkout(obj.getGymMembership());
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

	
	
	
	
	
	
	
}
