package com.example.fitsum.exception.exceptions;

public class CWrongBoardIdException extends RuntimeException{

    public CWrongBoardIdException(String msg, Throwable t) {
        super(msg, t);
    }

    public CWrongBoardIdException(String msg) {
        super(msg);
    }

    public CWrongBoardIdException(){
        super();
    }

}
