package com.example.fitsum.exception.exceptions;

public class CFileNotFoundException extends RuntimeException {

    public CFileNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

    public CFileNotFoundException(String msg) {
        super(msg);
    }

    public CFileNotFoundException() {
        super();
    }
}