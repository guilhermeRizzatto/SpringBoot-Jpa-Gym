package com.guiprojects.academy.entities;

import com.guiprojects.academy.dto.request.WorkLoadDTORequest;
import com.guiprojects.academy.dto.response.WorkLoadDTOResponse;
import com.guiprojects.academy.entities.enums.WeekDays;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.*;

@Entity
public class WorkLoad implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalTime entryTime;
	private LocalTime departureTime;
	
	@OneToOne
	@JoinColumn(name="trainer_id")
	private Trainer trainer;
	
	@ElementCollection(targetClass = WeekDays.class) 
	@CollectionTable(name = "workload_days", joinColumns = @JoinColumn(name = "workLoad_id")) 
	@Enumerated(EnumType.STRING) 
	@Column(name = "days") 
	private Set<WeekDays> days = new LinkedHashSet<>();
	
	
	public WorkLoad() {
	}
	
	public WorkLoad(Long id, LocalTime entryTime, LocalTime departureTime, Trainer trainer) {
		this.id = id;
		this.entryTime = entryTime;
		this.departureTime = departureTime;
		this.trainer = trainer;		
	}
	
	public WorkLoad(WorkLoadDTORequest obj) {
		this.id = obj.getId();
		this.entryTime = obj.getEntryTime();
		this.departureTime = obj.getDepartureTime();
		this.trainer = obj.getTrainer();
		addDays(obj.getDays());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalTime getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(LocalTime entryTime) {
		this.entryTime = entryTime;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	
	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Set<WeekDays> getDays() {
		return days;
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
		WorkLoad other = (WorkLoad) obj;
		return Objects.equals(id, other.id);
	}
	
	public void addDays(Set<WeekDays> daysObj){
		for(WeekDays x : daysObj) {
			days.add(x);
		}		
	}
	
	public Set<WeekDays> deleteDays(Set<WeekDays> daysObj){
		Set<WeekDays> daysToRemoveInDB = new LinkedHashSet<>();
		
		for(WeekDays x : days) {
			int repetitions = 0;
			for(WeekDays y : daysObj) {
				if(x == y) {
					repetitions += 1;
				}
			}
			if(repetitions == 0) {
				daysToRemoveInDB.add(x);
			}
		}
		days.clear();
		return daysToRemoveInDB; 	
	}

	public static List<WorkLoadDTOResponse> listWorkLoad (List<WorkLoad> list){
		List<WorkLoadDTOResponse> listDto = new ArrayList<>();
		for(WorkLoad x : list){
			listDto.add(new WorkLoadDTOResponse(x));
		}
		return listDto;
	}
	
	
	
	
	
}
