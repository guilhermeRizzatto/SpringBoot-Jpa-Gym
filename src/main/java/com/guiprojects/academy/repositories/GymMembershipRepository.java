package com.guiprojects.academy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.guiprojects.academy.entities.GymMembership;

import jakarta.transaction.Transactional;

public interface GymMembershipRepository extends JpaRepository<GymMembership, Long> {

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = """			
			UPDATE gym_membership
			SET registration_id = :registrationId 
			WHERE id = :memberId
			""")
	public GymMembership updateRegistration(Long registrationId, Long memberId);
	
}
