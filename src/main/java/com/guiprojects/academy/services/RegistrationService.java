package com.guiprojects.academy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		memberRepository.updateRegistration(obj.getId(), obj.getGymMembership().getId());
		return obj;	
	}
	
	public Registration update(Long id, Registration objWithNewParameters) {
		Registration registrationToUpdate = registrationRepository.findById(id).get();
		
		if(objWithNewParameters.getRegistrationDate() != null) registrationToUpdate.setRegistrationDate(objWithNewParameters.getRegistrationDate());
		if(objWithNewParameters.getMonthlyPeriod() != null) registrationToUpdate.setMonthlyPeriod(objWithNewParameters.getMonthlyPeriod());
		if(objWithNewParameters.getPrice() != null) registrationToUpdate.setPrice(objWithNewParameters.getPrice());
		if(objWithNewParameters.getInstallment() != null) registrationToUpdate.setInstallment(objWithNewParameters.getInstallment());
		
		registrationToUpdate.setValid();
		
		return registrationRepository.save(registrationToUpdate);
	}


}
