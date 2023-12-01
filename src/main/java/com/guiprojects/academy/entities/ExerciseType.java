package com.guiprojects.academy.entities;

 import com.guiprojects.academy.dto.request.ExerciseTypeDTORequest;
import com.guiprojects.academy.dto.response.ExerciseTypeDTOResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class ExerciseType implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String muscleGroup;
	
	public ExerciseType() {
	}

	public ExerciseType(Long id, String name, String muscleGroup) {
		this.id = id;
		this.name = name;
		this.muscleGroup = muscleGroup;
	}

	public ExerciseType(ExerciseTypeDTORequest obj) {
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
		ExerciseType other = (ExerciseType) obj;
		return Objects.equals(id, other.id);
	}

	public static List<ExerciseTypeDTOResponse> listExerciseType(List<ExerciseType> list){
		List<ExerciseTypeDTOResponse> listDto = new ArrayList<>();
		for(ExerciseType x : list){
			listDto.add(new ExerciseTypeDTOResponse(x));
		}
		return listDto;
	}
	
}
