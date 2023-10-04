package com.guiprojects.academy.dtoAuxiliary;

import com.guiprojects.academy.entities.Trainer;

//Only use in the WorkoutDTOResponse and WorkLoadResponse
//Contain only informations necessary for Workout and WorkLoad
public class TrainerDTO {
	
	private String name;
	private String email;
	
	public TrainerDTO() {
	}

	public TrainerDTO(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public TrainerDTO(Trainer obj) {
		this.name = obj.getName();
		this.email = obj.getEmail();
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
	
	
	
	

}
