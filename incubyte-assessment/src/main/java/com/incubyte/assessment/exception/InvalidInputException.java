package com.incubyte.assessment.exception;

public class InvalidInputException extends Exception {
    public InvalidInputException() {
        // calling the constructor of parent Exception
        super();
    }

    public InvalidInputException(String message) {
        // calling the constructor of parent Exception
        super(message);
    }
}
