package com.guiprojects.academy.services.exceptions;

public class TrainerWorkLoadException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public TrainerWorkLoadException (String msg) {
		super(msg); 
	}
	
}
