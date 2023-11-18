package com.guiprojects.academy.dtoAuxiliary;

import java.util.Set;

import com.guiprojects.academy.dto.response.ExerciseDTOResponse;
import com.guiprojects.academy.entities.Workout;

//Only use in the GymMembershipDTOResponse
//Contain only informations necessary for GymMembership
public class WorkoutDTOGymMembership {
	
	private Long id;
	private String description;
	
	private TrainerDTO trainer;
	
	private Set<ExerciseDTOResponse> exercises;
	
	public WorkoutDTOGymMembership() {
	}

	public WorkoutDTOGymMembership(Long id, String description, TrainerDTO trainer, Set<ExerciseDTOResponse> exercises) {
		this.description = description;
		this.trainer = trainer;
		this.exercises = exercises;
		this.id = id;
	}

	public WorkoutDTOGymMembership(Workout obj) {
		super();
		this.description = obj.getDescription();
		this.trainer = new TrainerDTO(obj.getTrainer());
		this.exercises = ExerciseDTOResponse.createExercises(obj.getExercises());
		obj.getId();
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
