package exception;

/**
 * This exception handles if the input time is as per the format mentioned in the doc [H]H:MM {AM|PM}
 */
public class TimeFormatException extends Exception {

    public TimeFormatException(String errorMessage) {
        super(errorMessage);
    }
}