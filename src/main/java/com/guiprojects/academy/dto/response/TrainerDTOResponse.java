package com.guiprojects.academy.dto.response;

import java.util.Objects;

import com.guiprojects.academy.entities.Trainer;

public class TrainerDTOResponse {
	
	private Long id;	
	private String name;
	private String email;
	
	public TrainerDTOResponse() {
	}
	
	public TrainerDTOResponse(Trainer obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainerDTOResponse other = (TrainerDTOResponse) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
