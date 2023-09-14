package com.guiprojects.academy.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.guiprojects.academy.entities.ExerciseType;
import com.guiprojects.academy.entities.Workout;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ExercisePK implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="workout_id")
	private Workout workout;
	
	@ManyToOne
	@JoinColumn(name="exerciseType_id")
	private ExerciseType exerciseType;
	
	public Workout getWorkout() {
		return workout;
	}
	public void setWorkout(Workout workout) {
		this.workout = workout;
	}
	public ExerciseType getExerciseType() {
		return exerciseType;
	}
	public void setExerciseType(ExerciseType exerciseType) {
		this.exerciseType = exerciseType;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(exerciseType, workout);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExercisePK other = (ExercisePK) obj;
		return Objects.equals(exerciseType, other.exerciseType) && Objects.equals(workout, other.workout);
	}
	
	
}
