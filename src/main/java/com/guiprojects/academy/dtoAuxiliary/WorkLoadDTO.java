package com.guiprojects.academy.dtoAuxiliary;

import java.time.LocalTime;
import java.util.Set;

import com.guiprojects.academy.entities.Trainer;
import com.guiprojects.academy.entities.WorkLoad;
import com.guiprojects.academy.entities.enums.WeekDays;

//Only use in the TrainerDTOResponse
//Contain only informations necessary for Trainer
public class WorkLoadDTO {
	
	private Long id;
	private LocalTime entryTime;
	private LocalTime departureTime;
	
	private Set<WeekDays> days;
	
	public WorkLoadDTO() {
	}

	public WorkLoadDTO(Long id, LocalTime entryTime, LocalTime departureTime, Trainer trainer, Set<WeekDays> days) {
		this.entryTime = entryTime;
		this.departureTime = departureTime;		
		this.days = days;
		this.id = id;
	}
	
	public WorkLoadDTO(WorkLoad obj) {
		if(obj == null) {
			this.entryTime = null;
			this.departureTime = null;
			this.days = null;
			this.id = null;
		} else {
			this.entryTime = obj.getEntryTime();
			this.departureTime = obj.getDepartureTime();
			this.days = obj.getDays();
			this.id = obj.getId();
		}
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

	public Set<WeekDays> getDays() {
		return days;
	}

	public void setDays(Set<WeekDays> days) {
		this.days = days;
	}
	
	
	
	

}
