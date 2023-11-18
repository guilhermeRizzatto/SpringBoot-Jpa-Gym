package com.guiprojects.academy.dtoAuxiliary;

import com.guiprojects.academy.entities.Workout;

//Only use in the TrainerDTOResponse
//Contain only informations necessary for Trainer
public class WorkoutDTOTrainer {

	private Long id;
	private String description;
	private GymMembershipDTOWorkout gymMembership;
	
	
	public WorkoutDTOTrainer() {
	}

	public WorkoutDTOTrainer(Long id, String description, GymMembershipDTOWorkout gymMembership) {
		this.description = description;
		this.gymMembership = gymMembership;
		this.id = id;
	}

	public WorkoutDTOTrainer(Workout obj) {
		this.description = obj.getDescription();
		this.gymMembership = new GymMembershipDTOWorkout(obj.getGymMembership());
		this.id = obj.getId();
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

	public GymMembershipDTOWorkout getGymMembership() {
		return gymMembership;
	}

	public void setGymMembership(GymMembershipDTOWorkout gymMembership) {
		this.gymMembership = gymMembership;
	}

	
	
	
	
	
	
	
}
