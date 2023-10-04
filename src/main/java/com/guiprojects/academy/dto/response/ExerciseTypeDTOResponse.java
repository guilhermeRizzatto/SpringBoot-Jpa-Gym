package com.guiprojects.academy.dto.response;

import com.guiprojects.academy.entities.ExerciseType;

public class ExerciseTypeDTOResponse {
	
	private Long id;
	private String name;
	private String muscleGroup;
	
	public ExerciseTypeDTOResponse() {
	}

	public ExerciseTypeDTOResponse(Long id, String name, String muscleGroup) {
		this.id = id;
		this.name = name;
		this.muscleGroup = muscleGroup;
	}
	
	public ExerciseTypeDTOResponse(ExerciseType obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.muscleGroup = obj.getMuscleGroup();
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

	public String getMuscleGroup() {
		return muscleGroup;
	}

	public void setMuscleGroup(String muscleGroup) {
		this.muscleGroup = muscleGroup;
	}
	
	

}
