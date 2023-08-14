package com.guiprojects.academy.projections;

import com.guiprojects.academy.entities.Registration;

public interface GymMembershipProjection {
	
	Long getId();
	String getName();
	String getCpf();
	String getPhone();
	Integer getAge();
	Double getWeight();
	Double getHeight();
	Registration getRegistration();

}
