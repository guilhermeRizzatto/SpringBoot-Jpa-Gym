package com.guiprojects.academy.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.guiprojects.academy.entities.Trainer;

import jakarta.transaction.Transactional;

public interface TrainerRepository extends JpaRepository<Trainer, Long>{

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = """			
			UPDATE trainer
			SET work_load_id = :workLoadId 
			WHERE id = :trainerId
			""")
	public void updateWorkLoad(Long workLoadId, Long trainerId);
	
	
	@Query("SELECT obj "
			+ "FROM Trainer obj "
			+ "LEFT JOIN FETCH obj.workouts w "
			+ "LEFT JOIN FETCH obj.workLoad wK "
			+ "LEFT JOIN FETCH wK.days "
			+ "WHERE obj.id = ?1")
	public Optional<Trainer> findFullById(Long id); 
}
