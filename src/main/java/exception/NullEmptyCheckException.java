package exception;

/**
 * This exception handles null or empty input time
 */
public class NullEmptyCheckException extends Exception {

    public NullEmptyCheckException(String errorMessage) {
        super(errorMessage);
    }
}
