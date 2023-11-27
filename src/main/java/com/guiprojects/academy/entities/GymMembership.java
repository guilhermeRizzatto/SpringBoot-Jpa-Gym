package com.guiprojects.academy.entities;

import com.guiprojects.academy.dto.request.GymMembershipDTORequest;
import com.guiprojects.academy.dto.response.GymMembershipDTOBaseResponse;
import com.guiprojects.academy.dto.response.GymMembershipDTOResponse;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class GymMembership implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String cpf;
	private String phone;
	private Integer age;
	private Double weight;
	private Double height;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="registration_id")
	private Registration registration;
	
	@OneToOne
	@JoinColumn(name="workout_id")
	private Workout workout;
	
	public GymMembership() {
	}

	public GymMembership(Long id, String name, String cpf, String phone, Integer age, Double weight, Double height) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.phone = phone;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}
	
	public GymMembership(GymMembershipDTORequest request) {
		this.id = request.getId();
		this.name = request.getName();
		this.cpf = request.getCpf();
		this.phone = request.getPhone();
		this.age = request.getAge();
		this.weight = request.getWeight();
		this.height = request.getHeight();
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
	
	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}
	
	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
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
		GymMembership other = (GymMembership) obj;
		return Objects.equals(id, other.id);
	}

	public static List<GymMembershipDTOBaseResponse> listMembersDTOBase(List<GymMembership> list){
		List<GymMembershipDTOBaseResponse> listDto = new ArrayList<>();
		for(GymMembership x : list){
			listDto.add(new GymMembershipDTOBaseResponse(x));
		}
		return listDto;
	}

	public static List<GymMembershipDTOResponse> listMembersDTOFull(List<GymMembership> list){
		List<GymMembershipDTOResponse> listDto = new ArrayList<>();
		for(GymMembership x : list){
			listDto.add(new GymMembershipDTOResponse(x));
		}
		return listDto;
	}

}
