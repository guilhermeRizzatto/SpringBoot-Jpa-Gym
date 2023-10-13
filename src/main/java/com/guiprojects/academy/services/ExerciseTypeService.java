package com.guiprojects.academy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guiprojects.academy.entities.ExerciseType;
import com.guiprojects.academy.repositories.ExerciseTypeRepository;

@Service
public class ExerciseTypeService {

	@Autowired
	private ExerciseTypeRepository exerciseTypeRepository;
	
	public ExerciseType findById (Long id) {
		Optional<ExerciseType> obj = exerciseTypeRepository.findById(id);
		return obj.get();
	}
	
	public ExerciseType insert (ExerciseType exerciseType) {
		return exerciseTypeRepository.save(exerciseType);
	}
}
