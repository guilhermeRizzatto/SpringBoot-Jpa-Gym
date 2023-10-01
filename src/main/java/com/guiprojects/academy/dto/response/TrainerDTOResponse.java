package com.guiprojects.academy.dto.response;

import com.guiprojects.academy.entities.Trainer;
import com.guiprojects.academy.entities.WorkLoad;

public class TrainerDTOResponse {
	
	private String name;
	private String email;
	
	private WorkLoad workLoad;
	
	public TrainerDTOResponse() {
	}
	
	public TrainerDTOResponse(Trainer obj) {
		this.name = obj.getName();
		this.email = obj.getEmail();
		this.workLoad = obj.getWorkLoad();
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
	
	public WorkLoad getWorkLoad() {
		return workLoad;
	}

	public void setWorkLoad(WorkLoad workLoad) {
		this.workLoad = workLoad;
	}

	
	

}
