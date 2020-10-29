package hu.szakdolgozat.tm.exceptions;

public class ControllerException extends Exception {

    private static final long serialVersionUID = 8526588819531933084L;
    
    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(String message, Throwable cause) {
        super(message, cause);
    }
}
