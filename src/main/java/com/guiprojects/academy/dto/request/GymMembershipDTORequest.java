package com.guiprojects.academy.dto.request;

import java.util.Objects;

public class GymMembershipDTORequest {
	
	private Long id;
	private String name;
	private String cpf;
	private String phone;
	private Integer age;
	private Double weight;
	private Double height;
	
	public GymMembershipDTORequest() {
	}

	public GymMembershipDTORequest(Long id, String name, String cpf, String phone, Integer age, Double weight,Double height) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.phone = phone;
		this.age = age;
		this.weight = weight;
		this.height = height;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
		GymMembershipDTORequest other = (GymMembershipDTORequest) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	

}
