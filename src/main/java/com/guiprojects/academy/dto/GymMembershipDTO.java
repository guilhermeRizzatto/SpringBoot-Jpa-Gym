package com.guiprojects.academy.dto;

import java.util.Objects;

import com.guiprojects.academy.entities.GymMembership;

//Only use in the RegistrationDTOResponse
//Contain only informations necessary for Registration
public class GymMembershipDTO {

	private Long id;
	private String name;
	private String cpf;
	private String phone;
	
	public GymMembershipDTO() {
	}

	public GymMembershipDTO(Long id, String name, String cpf, String phone) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.phone = phone;
	}
	
	public GymMembershipDTO(GymMembership obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.cpf = obj.getCpf();
		this.phone = obj.getPhone();
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
		GymMembershipDTO other = (GymMembershipDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
