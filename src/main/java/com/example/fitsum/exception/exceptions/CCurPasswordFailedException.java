package com.example.fitsum.exception.exceptions;

public class CCurPasswordFailedException extends RuntimeException{

    public CCurPasswordFailedException(String msg, Throwable t) {
        super(msg, t);
    }

    public CCurPasswordFailedException(String msg) {
        super(msg);
    }

    public CCurPasswordFailedException(){
        super();
    }

}
