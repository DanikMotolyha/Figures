package com.epam.figure.exception;

public class FigureException extends Exception {
    public FigureException() {
        super();
    }

    public FigureException(String message) {
        super(message);
    }

    public FigureException(String message, Throwable cause) {
        super(message, cause);
    }

    public FigureException(Throwable cause) {
        super(cause);
    }
}
