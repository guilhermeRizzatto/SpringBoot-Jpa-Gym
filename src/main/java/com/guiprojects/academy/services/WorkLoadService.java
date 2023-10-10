package com.guiprojects.academy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guiprojects.academy.entities.WorkLoad;
import com.guiprojects.academy.repositories.TrainerRepository;
import com.guiprojects.academy.repositories.WorkLoadRepository;

@Service
public class WorkLoadService {
	
	@Autowired
	private WorkLoadRepository workLoadRepository;
	
	@Autowired
	private TrainerRepository trainerRepository;
	
	public WorkLoad findById (Long id) {
		Optional<WorkLoad> obj = workLoadRepository.findWorkLoadById(id);
		return obj.get();
	}
	
	public WorkLoad insert (WorkLoad workLoad) {
		WorkLoad obj = workLoadRepository.save(workLoad);
		trainerRepository.updateWorkLoad(obj.getId(), obj.getTrainer().getId());
		return obj;
	}

}
