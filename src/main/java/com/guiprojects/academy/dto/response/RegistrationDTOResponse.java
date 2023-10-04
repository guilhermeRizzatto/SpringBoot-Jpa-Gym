package com.guiprojects.academy.dto.response;

import java.time.LocalDateTime;

import com.guiprojects.academy.dtoAuxiliary.GymMembershipDTO;
import com.guiprojects.academy.entities.GymMembership;
import com.guiprojects.academy.entities.Registration;

public class RegistrationDTOResponse {

	private LocalDateTime registrationDate;
	private Integer monthlyPeriod;
	private Double price;
	private Integer installment;
	private Boolean valid;
	private GymMembershipDTO gymMembership;
	
	public RegistrationDTOResponse() {
	}

	public RegistrationDTOResponse(Registration obj) {
		this.registrationDate = obj.getRegistrationDate();
		this.monthlyPeriod = obj.getMonthlyPeriod();
		this.price = obj.getPrice();
		this.installment = obj.getInstallment();
		this.valid = obj.getValid();
		this.gymMembership = new GymMembershipDTO(obj.getGymMembership());
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Integer getMonthlyPeriod() {
		return monthlyPeriod;
	}

	public void setMonthlyPeriod(Integer monthlyPeriod) {
		this.monthlyPeriod = monthlyPeriod;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getInstallment() {
		return installment;
	}

	public void setInstallment(Integer installment) {
		this.installment = installment;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public GymMembershipDTO getGymMembership() {
		return gymMembership;
	}

	public void setGymMembership(GymMembership gymMembership) {
		this.gymMembership = new GymMembershipDTO(gymMembership);
	}

	
	
	
	
	
	
}
