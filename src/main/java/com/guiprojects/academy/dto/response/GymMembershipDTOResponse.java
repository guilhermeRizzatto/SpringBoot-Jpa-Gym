package com.guiprojects.academy.dto.response;

import java.util.Objects;


import com.guiprojects.academy.entities.GymMembership;


public class GymMembershipDTOResponse {

	private Long id;
	private String name;
	private String phone;
	private Integer age;
	private Double weight;
	private Double height;
	
	public GymMembershipDTOResponse() {
	}
	
	public GymMembershipDTOResponse(GymMembership obj) {
		this.id = obj.getId();
		this.name = obj.getName();		
		this.phone = obj.getPhone();
		this.age = obj.getAge();
		this.weight = obj.getWeight();
		this.height = obj.getHeight();		
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
		GymMembershipDTOResponse other = (GymMembershipDTOResponse) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
