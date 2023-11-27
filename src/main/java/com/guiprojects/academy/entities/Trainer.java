package com.guiprojects.academy.entities;

import com.guiprojects.academy.dto.request.TrainerDTORequest;
import com.guiprojects.academy.dto.response.TrainerDTOBaseResponse;
import com.guiprojects.academy.dto.response.TrainerDTOResponse;
import com.guiprojects.academy.dtoAuxiliary.WorkoutDTOTrainer;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

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

	public static List<TrainerDTOBaseResponse> listTrainerDTOBase (List<Trainer> list){
		List<TrainerDTOBaseResponse> listDto = new ArrayList<>();
		for(Trainer x : list){
			listDto.add(new TrainerDTOBaseResponse(x));
		}
		return listDto;
	}

	public static List<TrainerDTOResponse> listTrainerDTOFull (List<Trainer> list){
		List<TrainerDTOResponse> listDto = new ArrayList<>();
		for(Trainer x : list){
			listDto.add(new TrainerDTOResponse(x));
		}
		return listDto;
	}

}
