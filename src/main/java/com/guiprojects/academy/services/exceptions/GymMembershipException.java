package com.guiprojects.academy.services.exceptions;

public class GymMembershipException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public GymMembershipException(String msg){
        super(msg);
    }
}
