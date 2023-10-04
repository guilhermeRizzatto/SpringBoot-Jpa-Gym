package com.guiprojects.academy.dto.request;

import com.guiprojects.academy.entities.ExerciseType;
import com.guiprojects.academy.entities.Workout;

public class ExerciseDTORequest {
	
	private ExerciseType exerciseType;
	private Workout workout;
	
	private Integer sets;
	private Integer reps;
	private Integer intervalSeconds;
	
	public ExerciseDTORequest() {
	}

	public ExerciseDTORequest(ExerciseType exerciseType, Workout workout, Integer sets, Integer reps,Integer intervalSeconds) {
		this.exerciseType = exerciseType;
		this.workout = workout;
		this.sets = sets;
		this.reps = reps;
		this.intervalSeconds = intervalSeconds;
	}

	public ExerciseType getExerciseType() {
		return exerciseType;
	}

	public void setExerciseType(ExerciseType exerciseType) {
		this.exerciseType = exerciseType;
	}

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
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
