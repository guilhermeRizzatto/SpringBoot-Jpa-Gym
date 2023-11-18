package com.guiprojects.academy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.guiprojects.academy.entities.Trainer;
import com.guiprojects.academy.repositories.TrainerRepository;
import com.guiprojects.academy.services.exceptions.DataBaseException;
import com.guiprojects.academy.services.exceptions.ResourceNotFoundException;
import com.guiprojects.academy.services.exceptions.TrainerWorkLoadException;

@Service
public class TrainerService {

	@Autowired
	private TrainerRepository trainerRepository;
	
	
	public Trainer findById (Long id) {
		Optional<Trainer> obj = trainerRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Trainer findFullById (Long id) {
		Optional<Trainer> obj = trainerRepository.findFullById(id);
		Trainer trainer = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		if(trainer.getWorkLoad() == null) throw new TrainerWorkLoadException("Trainer workLoad is empty");
		return trainer;
		
	}
	
	public Trainer insert (Trainer trainer) {
		return trainerRepository.save(trainer);
	}
	
	public Trainer update(Long id, Trainer objWithNewParameters) {
		Trainer trainerToUpdate = trainerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		
		if(objWithNewParameters.getName() != null) trainerToUpdate.setName(objWithNewParameters.getName());
		if(objWithNewParameters.getEmail() != null) trainerToUpdate.setEmail(objWithNewParameters.getEmail());
		
		return trainerRepository.save(trainerToUpdate);
	}
	
	public void delete(Long id) {
		try {
			if(trainerRepository.existsById(id)) {
				trainerRepository.deleteById(id);
				} else throw new ResourceNotFoundException(id);		 	
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	
}
