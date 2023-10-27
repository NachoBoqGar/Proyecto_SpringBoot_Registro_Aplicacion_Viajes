package com.app.exceptions;

//clase para crear una excepción personalizada para cuando se intente registrar un monbre de usuario o email que ya está registrado

public class UserException extends Exception{

    private final ErrorType errorType;

    public UserException(ErrorType errorType){
        this.errorType=errorType;
    }

    public ErrorType getErrorType(){
        return errorType;
    }

    public enum ErrorType{
        USER_EXIST,
        EMAIL_EXIST
    }
}
