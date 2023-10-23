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
	
	public Exercise update(Long workoutId, Long exerciseTypeId, Exercise objWithNewParameters) {
		Exercise exerciseToUpdate = exerciseRepository.findByIds(workoutId, exerciseTypeId).get();
		
		if(objWithNewParameters.getSets() != null) exerciseToUpdate.setSets(objWithNewParameters.getSets());
		if(objWithNewParameters.getReps() != null) exerciseToUpdate.setReps(objWithNewParameters.getReps());
		if(objWithNewParameters.getIntervalSeconds() != null) exerciseToUpdate.setIntervalSeconds(objWithNewParameters.getIntervalSeconds());
		
		return exerciseRepository.save(exerciseToUpdate);	
	}

}
