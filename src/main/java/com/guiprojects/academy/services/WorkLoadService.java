package com.guiprojects.academy.services;

import com.guiprojects.academy.entities.WorkLoad;
import com.guiprojects.academy.entities.enums.WeekDays;
import com.guiprojects.academy.repositories.TrainerRepository;
import com.guiprojects.academy.repositories.WorkLoadRepository;
import com.guiprojects.academy.services.exceptions.DataBaseException;
import com.guiprojects.academy.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class WorkLoadService {
	
	@Autowired
	private WorkLoadRepository workLoadRepository;
	
	@Autowired
	private TrainerRepository trainerRepository;
	
	public WorkLoad findById (Long id) {
		Optional<WorkLoad> obj = workLoadRepository.findWorkLoadById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public List<WorkLoad> findAll() {
		return workLoadRepository.findAllWorkLoad();
	}
	
	public WorkLoad insert (WorkLoad workLoad) {
		try{
			WorkLoad obj = workLoadRepository.save(workLoad);
			trainerRepository.updateWorkLoad(obj.getId(), obj.getTrainer().getId());
			return obj;
		} catch (DataIntegrityViolationException e){
			throw new DataBaseException(e.getMessage());
		}
	}
	
	public WorkLoad update(Long id, WorkLoad objWithNewParameters) {
		WorkLoad workLoadToUpdate = workLoadRepository.findWorkLoadById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		
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
