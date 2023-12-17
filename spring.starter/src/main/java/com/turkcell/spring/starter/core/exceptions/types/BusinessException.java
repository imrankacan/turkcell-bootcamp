package com.turkcell.spring.starter.core.exceptions.types;

public class BusinessException extends RuntimeException{

    //Constructor
    public BusinessException(String message) {
        super(message);
    }

}
