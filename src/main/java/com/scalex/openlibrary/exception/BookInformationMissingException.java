package com.scalex.openlibrary.exception;

public class BookInformationMissingException extends Exception{
    public BookInformationMissingException(String errMsg){
        super(errMsg);
    }
}
