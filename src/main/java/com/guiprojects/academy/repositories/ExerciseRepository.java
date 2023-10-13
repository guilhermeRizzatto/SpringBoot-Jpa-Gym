package com.guiprojects.academy.repositories;

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
}
