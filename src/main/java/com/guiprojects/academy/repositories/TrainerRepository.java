package com.guiprojects.academy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guiprojects.academy.entities.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Long>{

}