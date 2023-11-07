package com.guiprojects.academy.dto.request;

import java.time.LocalDate;
import java.util.Objects;

import com.guiprojects.academy.entities.GymMembership;


public class RegistrationDTORequest {
	
	private Long id;
	private LocalDate registrationDate;
	private Integer monthlyPeriod;
	private Double price;
	private Integer installment;
	private GymMembership gymMembership;
	
	public RegistrationDTORequest() {
	}
	
	public RegistrationDTORequest(Long id, LocalDate registrationDate, Integer monthlyPeriod, Double price,Integer installment, GymMembership gymMembership) {
		this.id = id;
		this.registrationDate = registrationDate;
		this.monthlyPeriod = monthlyPeriod;
		this.price = price;
		this.installment = installment;
		this.gymMembership = gymMembership;
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

	public GymMembership getGymMembership() {
		return gymMembership;
	}

	public void setGymMembership(GymMembership gymMembership) {
		this.gymMembership = gymMembership;
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
		RegistrationDTORequest other = (RegistrationDTORequest) obj;
		return Objects.equals(id, other.id);
	}

	
	
}
