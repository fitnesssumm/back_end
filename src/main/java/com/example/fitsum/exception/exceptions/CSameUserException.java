package com.example.fitsum.exception.exceptions;

public class CSameUserException extends RuntimeException{

    public CSameUserException(String msg, Throwable t) {
        super(msg, t);
    }

    public CSameUserException(String msg) {
        super(msg);
    }

    public CSameUserException(){
        super();
    }

}
