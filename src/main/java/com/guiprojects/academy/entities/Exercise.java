package com.guiprojects.academy.entities;

import java.io.Serializable;
import java.util.Objects;

import com.guiprojects.academy.entities.pk.ExercisePK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Exercise implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ExercisePK id = new ExercisePK();
	
	private Integer sets;
	private Integer reps;
	private Integer intervalSeconds;
	
	public Exercise() {
	}

	public Exercise(Workout workout, ExerciseType exerciseType, Integer sets, Integer reps, Integer intervalSeconds) {
		id.setExerciseType(exerciseType);
		id.setWorkout(workout);
		this.sets = sets;
		this.reps = reps;
		this.intervalSeconds = intervalSeconds;
	}
	
	public ExerciseType getExerciseType() {
		return id.getExerciseType();
	}
	
	public void setExerciseType(ExerciseType exerciseType) {
		id.setExerciseType(exerciseType);
	}
	
	public Workout getWorkout() {
		return id.getWorkout();
	}
	
	public void setWorkout(Workout workout) {
		id.setWorkout(workout);
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exercise other = (Exercise) obj;
		return Objects.equals(id, other.id);
	}
	
	

	
}
