package com.guiprojects.academy.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guiprojects.academy.entities.Exercise;
import com.guiprojects.academy.repositories.ExerciseRepository;

@Service
public class ExerciseService {
	
	@Autowired
	private ExerciseRepository exerciseRepository;
	
	public Set<Exercise> findByWorkoutId (Long workoutId) {
		Set<Exercise> obj = exerciseRepository.findByWorkoutId(workoutId);
		return obj;
	}
	
	public Exercise insert (Exercise exercise) {
		return exerciseRepository.save(exercise);
	}

}
