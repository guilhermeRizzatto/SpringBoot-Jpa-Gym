package com.guiprojects.academy.dtoAuxiliary;

import com.guiprojects.academy.entities.Trainer;

//Only use in the WorkoutDTOResponse and WorkLoadResponse
//Contain only informations necessary for Workout and WorkLoad
public class TrainerDTO {
	
	private Long id;
	private String name;
	private String email;
	
	public TrainerDTO() {
	}

	public TrainerDTO(Long id, String name, String email) {
		this.name = name;
		this.email = email;
		this.id = id;
	}

	public TrainerDTO(Trainer obj) {
		this.name = obj.getName();
		this.email = obj.getEmail();
		this.id = obj.getId();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
