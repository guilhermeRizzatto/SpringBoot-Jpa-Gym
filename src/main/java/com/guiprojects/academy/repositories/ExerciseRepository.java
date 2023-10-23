package com.guiprojects.academy.repositories;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.guiprojects.academy.entities.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long>{

	@Query(nativeQuery = true, value = """			
			SELECT * FROM exercise
			WHERE workout_id = :workoutId
			""")
	public Set<Exercise> findByWorkoutId(Long workoutId);
	
	@Query(nativeQuery = true, value = """			
			SELECT * FROM exercise
			WHERE workout_id = :workoutId
			AND exercise_type_id = :exerciseTypeId	
			""")
	public Optional<Exercise> findByIds(Long workoutId, Long exerciseTypeId);
}
