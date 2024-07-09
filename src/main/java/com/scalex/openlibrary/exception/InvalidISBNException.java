package com.scalex.openlibrary.exception;

public class InvalidISBNException extends Exception {
    public InvalidISBNException(String errMessage){
        super(errMessage);
    }
}
