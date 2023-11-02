package com.guiprojects.academy.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guiprojects.academy.entities.WorkLoad;
import com.guiprojects.academy.entities.enums.WeekDays;
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
	
	public WorkLoad update(Long id, WorkLoad objWithNewParameters) {
		WorkLoad workLoadToUpdate = workLoadRepository.findWorkLoadById(id).get();
		
		if(objWithNewParameters.getEntryTime() != null) workLoadToUpdate.setEntryTime(objWithNewParameters.getEntryTime());
		if(objWithNewParameters.getDepartureTime() != null) workLoadToUpdate.setDepartureTime(objWithNewParameters.getDepartureTime());
		
		if(objWithNewParameters.getDays() != null) {			
			deleteDaysInDB(workLoadToUpdate.deleteDays(objWithNewParameters.getDays()));
			workLoadToUpdate.addDays(objWithNewParameters.getDays());
		}
		
		return workLoadRepository.save(workLoadToUpdate);	
	}
	

	private void deleteDaysInDB(Set<WeekDays> daysToDelete) {
		for(WeekDays x : daysToDelete) {
			workLoadRepository.deleteDaysAlreadyExists(x.toString());
		}	
	}
	

}
