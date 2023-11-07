package com.guiprojects.academy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guiprojects.academy.entities.Workout;
import com.guiprojects.academy.repositories.GymMembershipRepository;
import com.guiprojects.academy.repositories.WorkoutRepository;

@Service
public class WorkoutService {

	@Autowired
	private WorkoutRepository workoutRepository;
	
	@Autowired
	private GymMembershipRepository gymMembershipRepository;
	
	public Workout findFullById (Long id) {
		Optional<Workout> obj = workoutRepository.findWorkoutFullById(id);
		return obj.get();
	}
	
	public Workout findBaseById (Long id) {
		Optional<Workout> obj = workoutRepository.findWorkoutBaseById(id);
		return obj.get();
	}
	
	public Workout insert (Workout workout) {
		Workout obj = workoutRepository.save(workout);
		gymMembershipRepository.updateWorkout(obj.getId(), obj.getGymMembership().getId());
		return obj;
	}
	
	public Workout update(Long id, Workout objWithNewParameters) {
		Workout workoutToUpdate = workoutRepository.findById(id).get();
		
		if(objWithNewParameters.getDescription() != null) workoutToUpdate.setDescription(objWithNewParameters.getDescription());		
		
		return workoutRepository.save(workoutToUpdate);
	}
	
	public void delete(Long id) {
		Workout obj = workoutRepository.findWorkoutBaseById(id).get();
		gymMembershipRepository.deleteWorkoutAssociated(obj.getGymMembership().getId());
		workoutRepository.deleteById(id);
	}
}
