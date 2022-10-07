package com.example.fitsum.exception.exceptions;

public class CEmailNotFoundException extends RuntimeException{
    public CEmailNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

    public CEmailNotFoundException(String msg) {
        super(msg);
    }

    public CEmailNotFoundException() {
        super();
    }
}
