package hu.szakdolgozat.tm.exceptions;

public class PersistenceException extends Exception {

    private static final long serialVersionUID = -781460253717346078L;

    public PersistenceException(String message) {
        super(message);
    }
    
    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
