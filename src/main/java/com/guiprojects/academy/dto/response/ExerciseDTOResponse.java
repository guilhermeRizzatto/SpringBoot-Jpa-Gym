package com.guiprojects.academy.dto.response;

import com.guiprojects.academy.entities.Exercise;

public class ExerciseDTOResponse {
	
	private ExerciseTypeDTOResponse exerciseType;
	
	private Integer sets;
	private Integer reps;
	private Integer intervalSeconds;
	
	public ExerciseDTOResponse() {
	}
	
	public ExerciseDTOResponse(ExerciseTypeDTOResponse exerciseType, Integer sets, Integer reps,Integer intervalSeconds) {
		this.exerciseType = exerciseType;
		this.sets = sets;
		this.reps = reps;
		this.intervalSeconds = intervalSeconds;
	}
	
	public ExerciseDTOResponse(Exercise obj) {
		this.exerciseType = new ExerciseTypeDTOResponse(obj.getExerciseType());
		this.sets = obj.getSets();
		this.reps = obj.getReps();
		this.intervalSeconds = obj.getIntervalSeconds();
	}

	public ExerciseTypeDTOResponse getExerciseType() {
		return exerciseType;
	}

	public void setExerciseType(ExerciseTypeDTOResponse exerciseType) {
		this.exerciseType = exerciseType;
	}

	public Integer getSets() {
		return sets;
	}

	public void setSets(Integer sets) {
		this.sets = sets;
	}

	public Integer getReps() {
		return reps;
	}

	public void setReps(Integer reps) {
		this.reps = reps;
	}

	public Integer getIntervalSeconds() {
		return intervalSeconds;
	}

	public void setIntervalSeconds(Integer intervalSeconds) {
		this.intervalSeconds = intervalSeconds;
	}
	
	
	
	
	

}
