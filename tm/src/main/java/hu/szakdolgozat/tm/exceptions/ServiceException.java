package hu.szakdolgozat.tm.exceptions;

public class ServiceException extends Exception {

    private static final long serialVersionUID = -1820473891394526579L;

    public ServiceException(String message) {
        super(message);
    }
    
    public ServiceException(Throwable cause) {
        super(cause);
    }
    
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
