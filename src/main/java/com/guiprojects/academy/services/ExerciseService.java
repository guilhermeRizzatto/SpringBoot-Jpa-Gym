package com.guiprojects.academy.services;

import com.guiprojects.academy.entities.Exercise;
import com.guiprojects.academy.repositories.ExerciseRepository;
import com.guiprojects.academy.services.exceptions.DataBaseException;
import com.guiprojects.academy.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ExerciseService {
	
	@Autowired
	private ExerciseRepository exerciseRepository;
	
	public Set<Exercise> findByWorkoutId (Long workoutId) {
		return exerciseRepository.findByWorkoutId(workoutId);
	}
	
	public Exercise insert (Exercise exercise) {
		try {
		return exerciseRepository.save(exercise);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	
	public Exercise update(Long workoutId, Long exerciseTypeId, Exercise objWithNewParameters) {
		Exercise exerciseToUpdate = exerciseRepository.findByIds(workoutId, exerciseTypeId).orElseThrow(() -> new ResourceNotFoundException("Not exist any exercise with this workoutId: " + workoutId + " and this exerciseTypeId: " + exerciseTypeId));;
		
		if(objWithNewParameters.getSets() != null) exerciseToUpdate.setSets(objWithNewParameters.getSets());
		if(objWithNewParameters.getReps() != null) exerciseToUpdate.setReps(objWithNewParameters.getReps());
		if(objWithNewParameters.getIntervalSeconds() != null) exerciseToUpdate.setIntervalSeconds(objWithNewParameters.getIntervalSeconds());
		
		return exerciseRepository.save(exerciseToUpdate);	
	}
	
	public void delete(Long workoutId, Long exerciseTypeId) {
		if(exerciseRepository.deleteByIds(workoutId, exerciseTypeId) == 0) throw new ResourceNotFoundException("Not exist any exercise with this workoutId: " + workoutId + " and this exerciseTypeId: " + exerciseTypeId);
	}

}
