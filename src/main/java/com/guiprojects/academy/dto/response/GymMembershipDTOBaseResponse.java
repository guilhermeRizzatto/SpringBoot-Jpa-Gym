package com.guiprojects.academy.dto.response;

import com.guiprojects.academy.entities.GymMembership;

//Only use for *insert* and *findById* method in GymMembershipController

public class GymMembershipDTOBaseResponse {

	private String name;
	private String phone;
	private Integer age;
	private Double weight;
	private Double height;
	
	public GymMembershipDTOBaseResponse() {
	}
	
	public GymMembershipDTOBaseResponse(GymMembership obj) {
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
