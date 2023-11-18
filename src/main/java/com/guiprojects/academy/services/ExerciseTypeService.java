package com.guiprojects.academy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guiprojects.academy.entities.ExerciseType;
import com.guiprojects.academy.repositories.ExerciseTypeRepository;
import com.guiprojects.academy.services.exceptions.ResourceNotFoundException;

@Service
public class ExerciseTypeService {

	@Autowired
	private ExerciseTypeRepository exerciseTypeRepository;
	
	public ExerciseType findById (Long id) {
		Optional<ExerciseType> obj = exerciseTypeRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public ExerciseType insert (ExerciseType exerciseType) {
		return exerciseTypeRepository.save(exerciseType);
	}
	
	public ExerciseType update(Long id, ExerciseType objWithNewParameters) {
		ExerciseType exerciseTypeToUpdate = exerciseTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		
		if(objWithNewParameters.getName() != null) exerciseTypeToUpdate.setName(objWithNewParameters.getName());	
		if(objWithNewParameters.getMuscleGroup() != null) exerciseTypeToUpdate.setMuscleGroup(objWithNewParameters.getMuscleGroup());	
		
		return exerciseTypeRepository.save(exerciseTypeToUpdate);
	}
	
	public void delete(Long id) {
		if(exerciseTypeRepository.existsById(id)) {
			exerciseTypeRepository.deleteById(id);			
		} else throw new ResourceNotFoundException(id);		
	}
}
