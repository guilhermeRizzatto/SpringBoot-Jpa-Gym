package com.guiprojects.academy.entities;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import com.guiprojects.academy.dto.request.WorkLoadDTORequest;
import com.guiprojects.academy.entities.enums.WeekDays;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

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
		this.days = addDays(obj.getDays());
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
	
	public Set<WeekDays> addDays(Set<WeekDays> daysDTO){
		Set<WeekDays> days = new LinkedHashSet<>();
		for(WeekDays x : daysDTO) {
			days.add(x);
		}
		return days;
	}
	
	
	
}
