package com.guiprojects.academy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guiprojects.academy.entities.GymMembership;

public interface GymMembershipRepository extends JpaRepository<GymMembership, Long> {

}
