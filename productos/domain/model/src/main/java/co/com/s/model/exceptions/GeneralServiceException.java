package co.com.s.model.exceptions;

public class GeneralServiceException extends RuntimeException {
    private static final long serialVersionUID = -5893065295516413234L;

    public GeneralServiceException() {
        super();
    }

    public GeneralServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public GeneralServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public GeneralServiceException(String message) {
        super(message);
    }

    public GeneralServiceException(Throwable cause) {
        super(cause);
    }
}
