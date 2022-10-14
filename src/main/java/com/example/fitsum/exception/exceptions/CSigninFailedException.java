package com.example.fitsum.exception.exceptions;

public class CSigninFailedException extends RuntimeException {

    public CSigninFailedException(String msg, Throwable t) {
        super(msg, t);
    }

    public CSigninFailedException(String msg) {
        super(msg);
    }

    public CSigninFailedException() {
        super();
    }
}
