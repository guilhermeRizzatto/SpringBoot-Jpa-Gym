package com.guiprojects.academy.services;

import com.guiprojects.academy.entities.GymMembership;
import com.guiprojects.academy.repositories.GymMembershipRepository;
import com.guiprojects.academy.services.exceptions.DataBaseException;
import com.guiprojects.academy.services.exceptions.GymMembershipException;
import com.guiprojects.academy.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GymMembershipService {

	@Autowired
	private GymMembershipRepository membershipRepository;
	
	public GymMembership insert (GymMembership member) {
			return membershipRepository.save(member);
	}
	
	public GymMembership findById(Long id) {	
		Optional<GymMembership> obj = membershipRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public GymMembership findFullById(Long id) {
		Optional<GymMembership> obj = membershipRepository.findFullById(id);
		GymMembership member = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		if(member.getWorkout() == null) throw new GymMembershipException("GymMembership workout is empty");
		return member;
	}
	
	public GymMembership update(Long id, GymMembership objWithNewParameters) {
		GymMembership memberToUpdate = membershipRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		
		if(objWithNewParameters.getName() != null) memberToUpdate.setName(objWithNewParameters.getName());
		if(objWithNewParameters.getAge() != null) memberToUpdate.setAge(objWithNewParameters.getAge());
		if(objWithNewParameters.getPhone() != null) memberToUpdate.setPhone(objWithNewParameters.getPhone());
		if(objWithNewParameters.getWeight() != null) memberToUpdate.setWeight(objWithNewParameters.getWeight());
		if(objWithNewParameters.getHeight() != null) memberToUpdate.setHeight(objWithNewParameters.getHeight());
		
		return membershipRepository.save(memberToUpdate);
	}
	
	public void delete(Long id) {
		try {
			if(membershipRepository.existsById(id)) {
				membershipRepository.deleteById(id);			
			} else throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	
	
	
	
}
