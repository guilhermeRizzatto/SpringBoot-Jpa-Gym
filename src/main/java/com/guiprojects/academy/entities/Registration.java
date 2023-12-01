package com.guiprojects.academy.entities;

import com.guiprojects.academy.dto.request.RegistrationDTORequest;
import com.guiprojects.academy.dto.response.RegistrationDTOResponse;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Registration implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate registrationDate;
	private Integer monthlyPeriod;
	private Double price;
	private Integer installment;
	private Boolean valid;
	
	@OneToOne
	@JoinColumn(name="gymMembership_id")
	private GymMembership gymMembership;
	
	public Registration() {
	}

	public Registration(Long id, LocalDate registrationDate, Integer monthlyPeriod, Double price, Integer installment, GymMembership gymMembership) {
		super();
		this.id = id;
		this.registrationDate = registrationDate;
		this.monthlyPeriod = monthlyPeriod;
		this.price = price;
		this.installment = installment;
		this.valid = isValid();
		this.gymMembership = gymMembership;
	}
	
	public Registration(RegistrationDTORequest request) {
		this.id = request.getId();
		this.registrationDate = request.getRegistrationDate();
		this.monthlyPeriod = request.getMonthlyPeriod();
		this.price = request.getPrice();
		this.installment = request.getInstallment();
		this.valid = isValid();
		this.gymMembership = request.getGymMembership();
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
	
	public void setValid() {
		this.valid = isValid();
	}

	public Double getInstallmentPrice() {
		return installmentValues();
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
	
	public Double installmentValues() {
		return price / installment;
	}
	
	public Boolean isValid() {
		LocalDate now = LocalDate.now();
		LocalDate expiryDate = registrationDate.plusMonths(monthlyPeriod.longValue());
		
		return expiryDate.isAfter(now) || expiryDate.isEqual(now);
	}
	
	//constructor auxiliary, only used for Patch Method in RegistrationsController to evite conflicts with isValid()
	public static Registration auxiliary(RegistrationDTORequest request) {
		Registration obj = new Registration();
		
		obj.setId(request.getId());
		obj.setRegistrationDate(request.getRegistrationDate());
		obj.setMonthlyPeriod(request.getMonthlyPeriod());
		obj.setPrice(request.getPrice());
		obj.setInstallment(request.getInstallment());
		obj.setGymMembership(request.getGymMembership());
		
		return obj;
	}

	public static List<RegistrationDTOResponse> listRegistration (List<Registration> list){
		List<RegistrationDTOResponse> listDto = new ArrayList<>();
		for(Registration x : list){
			listDto.add(new RegistrationDTOResponse(x));
		}
		return listDto;
	}
	

}
