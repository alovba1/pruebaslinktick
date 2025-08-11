package co.com.s.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class NoHandlerFoundException extends RuntimeException {
    private static final long serialVersionUID = 5270651972404315028L;
    public NoHandlerFoundException() {
        super();
    }
    public NoHandlerFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    public NoHandlerFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public NoHandlerFoundException(String message) {
        super(message);
    }
    public NoHandlerFoundException(Throwable cause) {
        super(cause);
    }
}
