package com.guiprojects.academy.dto.response;

import com.guiprojects.academy.dtoAuxiliary.GymMembershipDTOWorkout;
import com.guiprojects.academy.dtoAuxiliary.TrainerDTO;
import com.guiprojects.academy.entities.Workout;

//Only use when don't need the Exercises
public class WorkoutDTOResponseBASE {
	
	private Long id;
	private String description;
	private GymMembershipDTOWorkout gymMembership;
	
	private TrainerDTO trainer;
	
	
	public WorkoutDTOResponseBASE() {
	}

	public WorkoutDTOResponseBASE(Workout obj) {
		this.description = obj.getDescription();
		this.gymMembership = new GymMembershipDTOWorkout(obj.getGymMembership());
		this.trainer = new TrainerDTO(obj.getTrainer());
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

	public TrainerDTO getTrainer() {
		return trainer;
	}

	public void setTrainer(TrainerDTO trainer) {
		this.trainer = trainer;
	}


	

}
