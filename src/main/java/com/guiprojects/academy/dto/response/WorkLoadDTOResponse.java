package com.guiprojects.academy.dto.response;

import java.time.LocalTime;
import java.util.Set;

import com.guiprojects.academy.dtoAuxiliary.TrainerDTO;
import com.guiprojects.academy.entities.WorkLoad;
import com.guiprojects.academy.entities.enums.WeekDays;

public class WorkLoadDTOResponse {
	
	private LocalTime entryTime;
	private LocalTime departureTime;
	
	private TrainerDTO trainer;
	
	private Set<WeekDays> days;
	
	public WorkLoadDTOResponse() {
	}

	public WorkLoadDTOResponse(WorkLoad obj) {
		this.entryTime = obj.getEntryTime();
		this.departureTime = obj.getDepartureTime();
		this.trainer = new TrainerDTO(obj.getTrainer());
		this.days = obj.getDays();
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

	public TrainerDTO getTrainer() {
		return trainer;
	}

	public void setTrainer(TrainerDTO trainer) {
		this.trainer = trainer;
	}

	public Set<WeekDays> getDays() {
		return days;
	}

	public void setDays(Set<WeekDays> days) {
		this.days = days;
	}
	
	
	
}
