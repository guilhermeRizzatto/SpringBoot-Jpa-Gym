package com.guiprojects.academy.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.guiprojects.academy.dto.request.RegistrationDTORequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Registration implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime registrationDate;
	private Integer monthlyPeriod;
	private Double price;
	private Integer installment;
	private Boolean valid;
	
	@OneToOne
	@JoinColumn(name="gymMembership_id")
	private GymMembership gymMembership;
	
	public Registration() {
	}

	public Registration(Long id, LocalDateTime registrationDate, Integer monthlyPeriod, Double price, Integer installment, Boolean valid, GymMembership gymMembership) {
		super();
		this.id = id;
		this.registrationDate = registrationDate;
		this.monthlyPeriod = monthlyPeriod;
		this.price = price;
		this.installment = installment;
		this.valid = valid;
		this.gymMembership = gymMembership;
	}
	
	public Registration(RegistrationDTORequest request) {
		this.id = request.getId();
		this.registrationDate = request.getRegistrationDate();
		this.monthlyPeriod = request.getMonthlyPeriod();
		this.price = request.getPrice();
		this.installment = request.getInstallment();
		this.valid = request.getValid();
		this.gymMembership = request.getGymMembership();
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
		Registration other = (Registration) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
