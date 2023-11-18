package com.guiprojects.academy.dto.response;

import com.guiprojects.academy.dtoAuxiliary.WorkoutDTOGymMembership;
import com.guiprojects.academy.entities.GymMembership;


public class GymMembershipDTOResponse {

	private Long id;
	private String name;
	private String phone;
	private Integer age;
	private Double weight;
	private Double height;
	
	private WorkoutDTOGymMembership workout;
	
	public GymMembershipDTOResponse() {
	}
	
	public GymMembershipDTOResponse(GymMembership obj) {
		this.name = obj.getName();		
		this.phone = obj.getPhone();
		this.age = obj.getAge();
		this.weight = obj.getWeight();
		this.height = obj.getHeight();		
		this.workout = new WorkoutDTOGymMembership(obj.getWorkout());
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public WorkoutDTOGymMembership getWorkout() {
		return workout;
	}

	public void setWorkout(WorkoutDTOGymMembership workout) {
		this.workout = workout;
	}

	
	
}
