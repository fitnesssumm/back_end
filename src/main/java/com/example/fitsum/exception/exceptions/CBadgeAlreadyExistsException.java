package com.example.fitsum.exception.exceptions;

public class CBadgeAlreadyExistsException extends RuntimeException {

    public CBadgeAlreadyExistsException(String msg, Throwable t) {
        super(msg, t);
    }

    public CBadgeAlreadyExistsException(String msg) {
        super(msg);
    }

    public CBadgeAlreadyExistsException(){
        super();
    }

}
