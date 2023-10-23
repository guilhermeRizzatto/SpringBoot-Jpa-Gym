package com.guiprojects.academy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guiprojects.academy.entities.GymMembership;
import com.guiprojects.academy.repositories.GymMembershipRepository;

@Service
public class GymMembershipService {

	@Autowired
	private GymMembershipRepository membershipRepository;
	
	public GymMembership insert (GymMembership member) {
		return membershipRepository.save(member);
	}
	
	public GymMembership findById(Long id) {	
		Optional<GymMembership> obj = membershipRepository.findById(id);
		return obj.get();
	}
	
	public GymMembership findFullById(Long id) {
		Optional<GymMembership> obj = membershipRepository.findFullById(id);
		return obj.get();
	}
	
	public GymMembership update(Long id, GymMembership objWithNewParameters) {
		GymMembership memberToUpdate = membershipRepository.findById(id).get();
		
		if(objWithNewParameters.getName() != null) memberToUpdate.setName(objWithNewParameters.getName());
		if(objWithNewParameters.getAge() != null) memberToUpdate.setAge(objWithNewParameters.getAge());
		if(objWithNewParameters.getPhone() != null) memberToUpdate.setPhone(objWithNewParameters.getPhone());
		if(objWithNewParameters.getWeight() != null) memberToUpdate.setWeight(objWithNewParameters.getWeight());
		if(objWithNewParameters.getHeight() != null) memberToUpdate.setHeight(objWithNewParameters.getHeight());
		
		return membershipRepository.save(memberToUpdate);
	}
	
	
	
	
}
