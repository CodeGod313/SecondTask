package edu.epam.secondtask.exception;

public class WrongTetrahedronParametersException extends Exception {
    public WrongTetrahedronParametersException() {
    }

    public WrongTetrahedronParametersException(String message) {
        super(message);
    }

    public WrongTetrahedronParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongTetrahedronParametersException(Throwable cause) {
        super(cause);
    }
}
