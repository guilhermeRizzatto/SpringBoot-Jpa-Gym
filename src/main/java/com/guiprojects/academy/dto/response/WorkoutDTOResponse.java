package com.guiprojects.academy.dto.response;

import java.util.Set;

import com.guiprojects.academy.dtoAuxiliary.GymMembershipDTOWorkout;
import com.guiprojects.academy.dtoAuxiliary.TrainerDTO;
import com.guiprojects.academy.entities.Workout;

public class WorkoutDTOResponse {
	
	private String description;
	private GymMembershipDTOWorkout gymMembership;
	
	private TrainerDTO trainer;
	
	Set<ExerciseDTOResponse> exercises;
	
	public WorkoutDTOResponse() {
	}

	public WorkoutDTOResponse(Workout obj) {
		this.description = obj.getDescription();
		this.gymMembership = new GymMembershipDTOWorkout(obj.getGymMembership());
		this.trainer = new TrainerDTO(obj.getTrainer());
		this.exercises = obj.returnExerciseDTO(obj.getExercises());
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
