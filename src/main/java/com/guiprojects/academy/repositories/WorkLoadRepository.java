package com.guiprojects.academy.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.guiprojects.academy.entities.WorkLoad;

public interface WorkLoadRepository extends JpaRepository<WorkLoad, Long>{

	@Query("select obj FROM WorkLoad obj JOIN FETCH obj.days WHERE obj.id = ?1")
	public Optional<WorkLoad> findWorkLoadById(Long id);
}
