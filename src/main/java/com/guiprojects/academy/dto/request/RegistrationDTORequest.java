package com.guiprojects.academy.dto.request;

import java.time.LocalDateTime;
import java.util.Objects;

import com.guiprojects.academy.entities.GymMembership;


public class RegistrationDTORequest {
	
	private Long id;
	private LocalDateTime registrationDate;
	private Integer monthlyPeriod;
	private Double price;
	private Integer installment;
	private Boolean valid;
	private GymMembership gymMembership;
	
	public RegistrationDTORequest() {
	}
	
	public RegistrationDTORequest(Long id, LocalDateTime registrationDate, Integer monthlyPeriod, Double price,Integer installment, Boolean valid, GymMembership gymMembership) {
		this.id = id;
		this.registrationDate = registrationDate;
		this.monthlyPeriod = monthlyPeriod;
		this.price = price;
		this.installment = installment;
		this.valid = valid;
		this.gymMembership = gymMembership;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
