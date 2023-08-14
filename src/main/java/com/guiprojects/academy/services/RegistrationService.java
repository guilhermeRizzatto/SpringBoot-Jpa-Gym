package com.guiprojects.academy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guiprojects.academy.entities.GymMembership;
import com.guiprojects.academy.entities.Registration;
import com.guiprojects.academy.repositories.GymMembershipRepository;
import com.guiprojects.academy.repositories.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Autowired
	private GymMembershipRepository memberRepository;
	
	public Registration findById(Long id) {
		Optional<Registration> obj = registrationRepository.findById(id);
		return obj.get();
	}
	
	public Registration insert (Registration registration) {
		Registration obj = registrationRepository.save(registration);
		GymMembership member = registration.getGymMembership();
		member.setRegistration(obj);
		memberRepository.save(member);
		return obj;	
	}
	
	

}
