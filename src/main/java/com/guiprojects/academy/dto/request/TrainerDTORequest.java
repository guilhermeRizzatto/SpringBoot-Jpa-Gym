package com.guiprojects.academy.dto.request;

import java.util.Objects;

public class TrainerDTORequest {

	private Long id;	
	private String name;
	private String email;
	
	public TrainerDTORequest() {
	}
	
	public TrainerDTORequest(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
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
		TrainerDTORequest other = (TrainerDTORequest) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
