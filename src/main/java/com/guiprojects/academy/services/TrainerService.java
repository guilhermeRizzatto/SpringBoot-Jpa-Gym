package com.guiprojects.academy.services;

import com.guiprojects.academy.entities.Trainer;
import com.guiprojects.academy.repositories.TrainerRepository;
import com.guiprojects.academy.services.exceptions.DataBaseException;
import com.guiprojects.academy.services.exceptions.ResourceNotFoundException;
import com.guiprojects.academy.services.exceptions.TrainerWorkLoadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {

	@Autowired
	private TrainerRepository trainerRepository;
	
	
	public Trainer findById (Long id) {
		Optional<Trainer> obj = trainerRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public List<Trainer> findAll() {
		return trainerRepository.findAll();
	}

	public List<Trainer> findAllFull() {
		List<Trainer> list = trainerRepository.findFullAll();
		for(Trainer x : list) {
			if (x.getWorkLoad() == null) {
				throw new TrainerWorkLoadException("Trainer id: " + x.getId() + " has workLoad empty");
			}
		}
		return list;
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
