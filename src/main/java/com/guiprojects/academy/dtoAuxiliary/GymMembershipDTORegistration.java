package com.guiprojects.academy.dtoAuxiliary;

import com.guiprojects.academy.entities.GymMembership;

//Only use in the RegistrationDTOResponse
//Contain only informations necessary for Registration
public class GymMembershipDTORegistration {

	private String name;
	private String cpf;
	private String phone;
	
	public GymMembershipDTORegistration() {
	}

	public GymMembershipDTORegistration(Long id, String name, String cpf, String phone) {	
		this.name = name;
		this.cpf = cpf;
		this.phone = phone;
	}
	
	public GymMembershipDTORegistration(GymMembership obj) {
		this.name = obj.getName();
		this.cpf = obj.getCpf();
		this.phone = obj.getPhone();
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
	
	
}