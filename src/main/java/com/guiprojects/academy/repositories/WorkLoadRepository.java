package com.guiprojects.academy.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.guiprojects.academy.entities.WorkLoad;

import jakarta.transaction.Transactional;

public interface WorkLoadRepository extends JpaRepository<WorkLoad, Long>{

	@Query("select obj FROM WorkLoad obj JOIN FETCH obj.days WHERE obj.id = ?1")
	public Optional<WorkLoad> findWorkLoadById(Long id);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = """			
			DELETE
			FROM workload_days
			WHERE days = :day
			""")
	public void deleteDaysAlreadyExists(String day);
}
