package com.guiprojects.academy.dto.request;

import java.time.LocalTime;
import java.util.Set;

import com.guiprojects.academy.entities.Trainer;
import com.guiprojects.academy.entities.enums.WeekDays;

public class WorkLoadDTORequest {
	
	private Long id;

	private LocalTime entryTime;
	private LocalTime departureTime;
	
	private Trainer trainer;
	
	private Set<WeekDays> days;
	
	public WorkLoadDTORequest() {
	}

	public WorkLoadDTORequest(Long id, LocalTime entryTime, LocalTime departureTime, Trainer trainer, Set<WeekDays> days) {
		this.id = id;
		this.entryTime = entryTime;
		this.departureTime = departureTime;
		this.trainer = trainer;
		this.days = days;
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

	public void setDays(Set<WeekDays> days) {
		this.days = days;
	}
	
	
	
	
	
	

}
