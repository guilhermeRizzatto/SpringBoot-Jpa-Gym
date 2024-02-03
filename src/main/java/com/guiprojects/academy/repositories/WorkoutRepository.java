package com.guiprojects.academy.repositories;

import com.guiprojects.academy.entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface WorkoutRepository extends JpaRepository<Workout, Long>{

	@Query("select obj FROM Workout obj LEFT JOIN FETCH obj.exercises WHERE obj.id = ?1")
	public Optional<Workout> findWorkoutFullById(Long id);
	
	@Query("select obj FROM Workout obj WHERE obj.id = ?1")
	public Optional<Workout> findWorkoutBaseById(Long id);

	@Query("select obj FROM Workout obj LEFT JOIN FETCH obj.exercises")
	public List<Workout> findAllWorkoutFull();
	
	
	@Query("select obj FROM Workout obj WHERE obj.trainer.id = ?1")
	public List<Workout> findWorkoutBaseByTrainerId(Long trainerId);
}