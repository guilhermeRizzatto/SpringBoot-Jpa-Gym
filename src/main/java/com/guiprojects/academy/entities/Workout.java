package com.guiprojects.academy.entities;

import com.guiprojects.academy.dto.request.WorkoutDTORequestPOST;
import com.guiprojects.academy.dto.response.ExerciseDTOResponse;
import com.guiprojects.academy.dto.response.WorkoutDTOResponseBASE;
import com.guiprojects.academy.dto.response.WorkoutDTOResponseFULL;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
public class Workout implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@OneToOne
	@JoinColumn(name="gymMembership_id")
	private GymMembership gymMembership;
	
	@ManyToOne
	@JoinColumn(name="trainer_id")
	private Trainer trainer;
	
	@OneToMany(mappedBy = "id.workout", cascade = CascadeType.ALL)
	Set<Exercise> exercises = new LinkedHashSet<>();
	
	public Workout() {
	}

	public Workout(Long id, String description, GymMembership gymMembership, Trainer trainer) {
		this.id = id;
		this.description = description;
		this.gymMembership = gymMembership;
		this.trainer = trainer;
	}
	
	public Workout(WorkoutDTORequestPOST obj) {
		this.id = obj.getId();
		this.description = obj.getDescription();
		this.gymMembership = obj.getGymMembership();
		this.trainer = obj.getTrainer();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public GymMembership getGymMembership() {
		return gymMembership;
	}

	public void setGymMembership(GymMembership gymMembership) {
		this.gymMembership = gymMembership;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Set<Exercise> getExercises(){
		return exercises;
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
		Workout other = (Workout) obj;
		return Objects.equals(id, other.id);
	}
	public Set<ExerciseDTOResponse> returnExerciseDTO(Set<Exercise> exercises){
		Set<ExerciseDTOResponse> exercisesDTO = new LinkedHashSet<>();
		for(Exercise x : exercises) {
			ExerciseDTOResponse dto = new ExerciseDTOResponse(x);
			exercisesDTO.add(dto);
		}
		return exercisesDTO;
	}

	public static List<WorkoutDTOResponseBASE> listWorkoutDTOBase (List<Workout> list){
		List<WorkoutDTOResponseBASE> listDto = new ArrayList<>();
		for(Workout x : list){
			listDto.add(new WorkoutDTOResponseBASE(x));
		}
		return listDto;
	}

	public static List<WorkoutDTOResponseFULL> listWorkoutDTOFull (List<Workout> list){
		List<WorkoutDTOResponseFULL> listDto = new ArrayList<>();
		for(Workout x : list){
			listDto.add(new WorkoutDTOResponseFULL(x));
		}
		return listDto;
	}
	
	

}
