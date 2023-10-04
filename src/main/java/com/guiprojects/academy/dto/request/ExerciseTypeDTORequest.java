package com.guiprojects.academy.dto.request;

public class ExerciseTypeDTORequest {
	
	private Long id;
	private String name;
	private String muscleGroup;
	
	public ExerciseTypeDTORequest() {
	}

	public ExerciseTypeDTORequest(Long id, String name, String muscleGroup) {
		this.id = id;
		this.name = name;
		this.muscleGroup = muscleGroup;
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
