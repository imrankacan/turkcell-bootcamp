package com.turkcell.spring.starter.business.exceptions;

public class BusinessException extends RuntimeException{

    //Constructor
    public BusinessException(String message) {
        super(message);
    }

}
