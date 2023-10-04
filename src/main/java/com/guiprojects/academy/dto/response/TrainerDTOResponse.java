package com.guiprojects.academy.dto.response;

import java.util.Set;

import com.guiprojects.academy.dtoAuxiliary.WorkLoadDTO;
import com.guiprojects.academy.dtoAuxiliary.WorkoutDTOTrainer;
import com.guiprojects.academy.entities.Trainer;

public class TrainerDTOResponse {
	
	private String name;
	private String email;
	
	private WorkLoadDTO workLoad;
	
	Set<WorkoutDTOTrainer> workouts;
	
	public TrainerDTOResponse() {
	}
	
	public TrainerDTOResponse(Trainer obj) {
		this.name = obj.getName();
		this.email = obj.getEmail();
		this.workLoad = new WorkLoadDTO(obj.getWorkLoad());
		this.workouts = obj.addWorkouts(obj.getWorkouts());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public WorkLoadDTO getWorkLoad() {
		return workLoad;
	}

	public void setWorkLoad(WorkLoadDTO workLoad) {
		this.workLoad = workLoad;
	}

	public Set<WorkoutDTOTrainer> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(Set<WorkoutDTOTrainer> workouts) {
		this.workouts = workouts;
	}

	
	
	

}
