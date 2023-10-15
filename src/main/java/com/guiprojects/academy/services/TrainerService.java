package com.guiprojects.academy.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guiprojects.academy.entities.Trainer;
import com.guiprojects.academy.repositories.TrainerRepository;

@Service
public class TrainerService {

	@Autowired
	private TrainerRepository trainerRepository;
	
	
	public Trainer findById (Long id) {
		Optional<Trainer> obj = trainerRepository.findById(id);
		return obj.get();
	}
	
	public Set<Trainer> findFullById (Long id) {
		Set<Trainer> list = trainerRepository.findFullById(id);
		return list;
	}
	
	public Trainer insert (Trainer trainer) {
		return trainerRepository.save(trainer);
	}
}
