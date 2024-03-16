package com.dan.model.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message){
        super(message);
    }

    public static String getNAME() {
        return "NotFoundException";
    }
}
