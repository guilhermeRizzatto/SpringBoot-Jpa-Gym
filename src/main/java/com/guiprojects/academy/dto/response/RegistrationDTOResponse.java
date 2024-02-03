package com.guiprojects.academy.dto.response;

import com.guiprojects.academy.dtoAuxiliary.GymMembershipDTORegistration;
import com.guiprojects.academy.entities.GymMembership;
import com.guiprojects.academy.entities.Registration;

import java.time.LocalDate;

public class RegistrationDTOResponse {

	private Long id;
	private LocalDate registrationDate;
	private Integer monthlyPeriod;
	private Double price;
	private Integer installment;
	private Boolean valid;
	private Double installmentPrice;
	private GymMembershipDTORegistration gymMembership;
	
	public RegistrationDTOResponse() {
	}

	public RegistrationDTOResponse(Registration obj) {
		this.registrationDate = obj.getRegistrationDate();
		this.monthlyPeriod = obj.getMonthlyPeriod();
		this.price = obj.getPrice();
		this.installment = obj.getInstallment();
		this.valid = obj.getValid();
		this.installmentPrice = formatInstallmentPrice(obj.getInstallmentPrice());
		this.gymMembership = new GymMembershipDTORegistration(obj.getGymMembership());
		this.id = obj.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
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

	public void setValid(Registration obj) {
		this.valid = obj.getValid();
	}
	
	public Double getInstallmentPrice() {
		return installmentPrice;
	}

	public void setInstallmentPrice(Double installmentPrice) {
		this.installmentPrice = installmentPrice;
	}

	public GymMembershipDTORegistration getGymMembership() {
		return gymMembership;
	}

	public void setGymMembership(GymMembership gymMembership) {
		this.gymMembership = new GymMembershipDTORegistration(gymMembership);
	}

	public double formatInstallmentPrice(Double installmentPrice) {
		return Double.valueOf(String.format("%.2f", installmentPrice));
	}
	
	
	
	
	
}
