package com.guiprojects.academy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guiprojects.academy.entities.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long>{

}
