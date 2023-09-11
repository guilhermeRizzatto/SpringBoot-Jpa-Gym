package com.guiprojects.academy.entities.enums;

public enum WeekDays {

	MONDAY(1),
	TUESDAY(2),
	WEDNESDAY(3),
	THURSDAY(4),
	FRIDAY(5),
	SATURDAY(6),
	SUNDAY(0);
	
	private int code;
	
	private WeekDays(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static WeekDays valueOf(int code) {
		for(WeekDays value : WeekDays.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid WeekDays code");
	}
		
}
