package com.guiprojects.academy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guiprojects.academy.entities.WorkLoad;

public interface WorkLoadRepository extends JpaRepository<WorkLoad, Long> {

}
