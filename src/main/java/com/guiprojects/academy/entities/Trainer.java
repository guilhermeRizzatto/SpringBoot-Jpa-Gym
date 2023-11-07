package com.guiprojects.academy.entities;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import com.guiprojects.academy.dto.request.TrainerDTORequest;
import com.guiprojects.academy.dtoAuxiliary.WorkoutDTOTrainer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Trainer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="workLoad_id")
	private WorkLoad workLoad;
	
	@OneToMany(mappedBy = "trainer")
	private Set<Workout> workouts = new LinkedHashSet<>();
	
	public Trainer() {
	}
	
	public Trainer(Long id, String email, String name,WorkLoad workLoad) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.workLoad = workLoad;
	}
	
	public Trainer(TrainerDTORequest obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public WorkLoad getWorkLoad() {
		return workLoad;
	}

	public void setWorkLoad(WorkLoad workLoad) {
		this.workLoad = workLoad;
	}
	
	public Set<Workout> getWorkouts() {
		return workouts;
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
		Trainer other = (Trainer) obj;
		return Objects.equals(id, other.id);
	}
	
	public Set<WorkoutDTOTrainer> addWorkouts(Set<Workout> workouts){
		Set<WorkoutDTOTrainer> workoutDTOs = new LinkedHashSet<>();
		for(Workout x : workouts) {
			WorkoutDTOTrainer obj = new WorkoutDTOTrainer(x);
			workoutDTOs.add(obj);
		}
		return workoutDTOs;
	}
	
	

}
