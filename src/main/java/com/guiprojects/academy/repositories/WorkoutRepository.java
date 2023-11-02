package com.guiprojects.academy.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.guiprojects.academy.entities.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Long>{

	@Query("select obj FROM Workout obj LEFT JOIN FETCH obj.exercises WHERE obj.id = ?1")
	public Optional<Workout> findWorkoutFullById(Long id);
	
	@Query("select obj FROM Workout obj WHERE obj.id = ?1")
	public Optional<Workout> findWorkoutBaseById(Long id);
	
	
}