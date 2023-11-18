package com.guiprojects.academy.dto.response;

import com.guiprojects.academy.entities.Trainer;

//Only use for *insert* and *findById* method in TrainerController

public class TrainerDTOBaseResponse {
	
	private Long id;
	private String name;
	private String email;

	public TrainerDTOBaseResponse() {
	}
	
	public TrainerDTOBaseResponse(Trainer obj) {
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
