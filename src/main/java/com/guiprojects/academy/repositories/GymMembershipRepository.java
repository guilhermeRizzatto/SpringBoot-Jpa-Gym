package com.guiprojects.academy.repositories;

import com.guiprojects.academy.entities.GymMembership;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GymMembershipRepository extends JpaRepository<GymMembership, Long> {

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = """			
			UPDATE gym_membership
			SET registration_id = :registrationId 
			WHERE id = :memberId
			""")
	public void updateRegistration(Long registrationId, Long memberId);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = """			
			UPDATE gym_membership
			SET workout_id = :workoutId
			WHERE id = :memberId
			""")
	public void updateWorkout(Long workoutId, Long memberId);
	
	@Query("SELECT obj FROM GymMembership obj "
			+ "LEFT JOIN FETCH obj.workout AS w "
			+ "LEFT JOIN FETCH w.exercises "
			+ "WHERE obj.id = ?1")
	public Optional<GymMembership> findFullById(Long id);

	@Query("SELECT obj FROM GymMembership obj "
			+ "LEFT JOIN FETCH obj.workout AS w "
			+ "LEFT JOIN FETCH w.exercises ")
	public List<GymMembership> findAllFull();
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = """			
			UPDATE gym_membership
			SET workout_id = NULL
			WHERE id = :memberId
			""")
	public void deleteWorkoutAssociated(Long memberId);
	
	
}
