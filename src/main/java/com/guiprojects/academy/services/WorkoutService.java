package com.guiprojects.academy.services;

import com.guiprojects.academy.entities.Workout;
import com.guiprojects.academy.repositories.GymMembershipRepository;
import com.guiprojects.academy.repositories.WorkoutRepository;
import com.guiprojects.academy.services.exceptions.DataBaseException;
import com.guiprojects.academy.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

	@Autowired
	private WorkoutRepository workoutRepository;
	
	@Autowired
	private GymMembershipRepository gymMembershipRepository;
	
	public Workout findFullById (Long id) {
		Optional<Workout> obj = workoutRepository.findWorkoutFullById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Workout findBaseById (Long id) {
		Optional<Workout> obj = workoutRepository.findWorkoutBaseById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public List<Workout> findAll() {
		return workoutRepository.findAllWorkoutFull();
	}
	
	public List<Workout> findBaseByTrainerId(Long trainerId){
		return workoutRepository.findWorkoutBaseByTrainerId(trainerId);
	}
	
	public Workout insert (Workout workout) {
		try {
		Workout obj = workoutRepository.save(workout);
		gymMembershipRepository.updateWorkout(obj.getId(), obj.getGymMembership().getId());
		return obj;
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	
	public Workout update(Long id, Workout objWithNewParameters) {
		Workout workoutToUpdate = workoutRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		
		if(objWithNewParameters.getDescription() != null) workoutToUpdate.setDescription(objWithNewParameters.getDescription());		
		
		return workoutRepository.save(workoutToUpdate);
	}
	
	public void delete(Long id) {
		try {
		if(workoutRepository.existsById(id)) {
			Workout obj = workoutRepository.findWorkoutBaseById(id).orElseThrow(() -> new ResourceNotFoundException(id));
			gymMembershipRepository.deleteWorkoutAssociated(obj.getGymMembership().getId());
			workoutRepository.deleteById(id);
			} else throw new ResourceNotFoundException(id);	 	
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	
}
