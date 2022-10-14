package com.example.fitsum.exception.exceptions;

public class CBoardNotFoundException extends RuntimeException{

    public CBoardNotFoundException() {
        super();
    }

    public CBoardNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

    public CBoardNotFoundException(String msg) {
        super(msg);
    }

}