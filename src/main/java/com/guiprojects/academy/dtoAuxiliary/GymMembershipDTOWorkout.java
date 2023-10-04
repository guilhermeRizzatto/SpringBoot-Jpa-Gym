package com.guiprojects.academy.dtoAuxiliary;

import com.guiprojects.academy.entities.GymMembership;

//Only use in the WorkoutDTOResponse
//Contain only informations necessary for Workout
public class GymMembershipDTOWorkout {
	
	private String name;
	private String phone;
	private Integer age;
	private Double weight;
	private Double height;
	
	public GymMembershipDTOWorkout() {
	}
	
	
	public GymMembershipDTOWorkout(String name, String phone, Integer age, Double weight, Double height) {
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}


	public GymMembershipDTOWorkout(GymMembership obj) {
		this.name = obj.getName();
		this.phone = obj.getPhone();
		this.age = obj.getAge();
		this.weight = obj.getWeight();
		this.height = obj.getHeight();
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
	
	
	
	
	
	
	

}
