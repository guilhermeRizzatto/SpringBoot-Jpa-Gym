package com.guiprojects.academy.dto.response;

import java.util.LinkedHashSet;
import java.util.Set;

import com.guiprojects.academy.dtoAuxiliary.WorkLoadDTO;
import com.guiprojects.academy.dtoAuxiliary.WorkoutDTOTrainer;
import com.guiprojects.academy.entities.Trainer;

public class TrainerDTOResponse {
	
	private String name;
	private String email;
	
	private WorkLoadDTO workLoad;
	
	private Set<WorkoutDTOTrainer> workouts;
	
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
	
	public static Set<TrainerDTOResponse> createExercises (Set<Trainer> list) {
		Set<TrainerDTOResponse> trainers = new LinkedHashSet<>();
		
		for(Trainer x : list) {
			TrainerDTOResponse trainer = new TrainerDTOResponse();
			
			trainer.setEmail(x.getEmail());
			trainer.setName(x.getName()); 
			trainer.setWorkLoad(new WorkLoadDTO(x.getWorkLoad())); 
			trainer.setWorkouts(x.addWorkouts(x.getWorkouts())); 
			
			trainers.add(trainer);
		}
		
		return trainers;
	}

	
	
	

}
