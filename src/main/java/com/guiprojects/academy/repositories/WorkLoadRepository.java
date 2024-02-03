package com.guiprojects.academy.repositories;

import com.guiprojects.academy.entities.WorkLoad;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface WorkLoadRepository extends JpaRepository<WorkLoad, Long>{

	@Query("select obj FROM WorkLoad obj LEFT JOIN FETCH obj.days WHERE obj.id = ?1")
	public Optional<WorkLoad> findWorkLoadById(Long id);

	@Query("select obj FROM WorkLoad obj LEFT JOIN FETCH obj.days")
	public List<WorkLoad> findAllWorkLoad();
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = """			
			DELETE
			FROM workload_days
			WHERE days = :day
			""")
	public void deleteDaysAlreadyExists(String day);
	
	
}
