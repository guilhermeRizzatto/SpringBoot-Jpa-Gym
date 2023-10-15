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
	
	public Workout findById (Long id) {
		Optional<Workout> obj = workoutRepository.findWorkoutById(id);
		return obj.get();
	}
	
	public Workout insert (Workout workout) {
		Workout obj = workoutRepository.save(workout);
		gymMembershipRepository.updateWorkout(obj.getId(), obj.getGymMembership().getId());
		return obj;
	}
}
