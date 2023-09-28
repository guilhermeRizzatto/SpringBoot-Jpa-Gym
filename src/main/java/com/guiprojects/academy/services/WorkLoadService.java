package com.guiprojects.academy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guiprojects.academy.entities.WorkLoad;
import com.guiprojects.academy.repositories.WorkLoadRepository;

@Service
public class WorkLoadService {
	
	@Autowired
	private WorkLoadRepository repository;
	
	public WorkLoad insert (WorkLoad workLoad) {
		return repository.save(workLoad);
	}

}
