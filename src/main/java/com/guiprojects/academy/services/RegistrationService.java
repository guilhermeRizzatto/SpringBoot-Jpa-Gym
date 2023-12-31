package com.guiprojects.academy.services;

import com.guiprojects.academy.entities.Registration;
import com.guiprojects.academy.repositories.GymMembershipRepository;
import com.guiprojects.academy.repositories.RegistrationRepository;
import com.guiprojects.academy.services.exceptions.DataBaseException;
import com.guiprojects.academy.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Autowired
	private GymMembershipRepository memberRepository;
	
	public Registration findById(Long id) {
		Optional<Registration> obj = registrationRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public List<Registration> findAll() {
		return registrationRepository.findAll();
	}
	
	public Registration insert (Registration registration) {
		try {
			Registration obj = registrationRepository.save(registration);
			memberRepository.updateRegistration(obj.getId(), obj.getGymMembership().getId());
			return obj;
		} catch (DataIntegrityViolationException e){
			throw new DataBaseException(e.getMessage());
		}
	}
	
	public Registration update(Long id, Registration objWithNewParameters) {
		Registration registrationToUpdate = registrationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		
		if(objWithNewParameters.getRegistrationDate() != null) registrationToUpdate.setRegistrationDate(objWithNewParameters.getRegistrationDate());
		if(objWithNewParameters.getMonthlyPeriod() != null) registrationToUpdate.setMonthlyPeriod(objWithNewParameters.getMonthlyPeriod());
		if(objWithNewParameters.getPrice() != null) registrationToUpdate.setPrice(objWithNewParameters.getPrice());
		if(objWithNewParameters.getInstallment() != null) registrationToUpdate.setInstallment(objWithNewParameters.getInstallment());
		
		registrationToUpdate.setValid();
		
		return registrationRepository.save(registrationToUpdate);
	}


}
