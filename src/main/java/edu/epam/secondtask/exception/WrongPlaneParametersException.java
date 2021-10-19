package edu.epam.secondtask.exception;

public class WrongPlaneParametersException extends Exception{
    public WrongPlaneParametersException() {
    }

    public WrongPlaneParametersException(String message) {
        super(message);
    }

    public WrongPlaneParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongPlaneParametersException(Throwable cause) {
        super(cause);
    }
}
