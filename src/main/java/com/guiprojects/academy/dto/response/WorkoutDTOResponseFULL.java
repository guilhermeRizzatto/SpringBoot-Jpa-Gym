package com.guiprojects.academy.dto.response;

import java.util.Set;

import com.guiprojects.academy.dtoAuxiliary.GymMembershipDTOWorkout;
import com.guiprojects.academy.dtoAuxiliary.TrainerDTO;
import com.guiprojects.academy.entities.Workout;

//Only use when need the Exercises
public class WorkoutDTOResponseFULL {
	
	private String description;
	private GymMembershipDTOWorkout gymMembership;
	
	private TrainerDTO trainer;
	
	private Set<ExerciseDTOResponse> exercises;
	
	public WorkoutDTOResponseFULL() {
	}

	public WorkoutDTOResponseFULL(Workout obj) {
		this.description = obj.getDescription();
		this.gymMembership = new GymMembershipDTOWorkout(obj.getGymMembership());
		this.trainer = new TrainerDTO(obj.getTrainer());
		this.exercises = ExerciseDTOResponse.createExercises(obj.getExercises());
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

	public Set<ExerciseDTOResponse> getExercises() {
		return exercises;
	}

	public void setExercises(Set<ExerciseDTOResponse> exercises) {
		this.exercises = exercises;
	}

	

	

}
