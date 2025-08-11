package co.com.s.model.exceptions;

import co.com.s.model.beans.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.logging.Logger;

@RestControllerAdvice
public class ErrorHandlerConfig extends ResponseEntityExceptionHandler {
    static Logger log = Logger.getLogger(ErrorHandlerConfig.class.getName());
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> all(Exception e, WebRequest request){
        log.severe(e.getMessage());
        log.severe(e.getLocalizedMessage());
        Response<?> response = new Response<>(false,500, "Internal Server Error" , null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(ValidateServiceException.class)
    public ResponseEntity<?> validateServiceException(ValidateServiceException e, WebRequest request){
        log.severe(e.getMessage());
        log.severe(e.getLocalizedMessage());
        Response<?> response = new Response<>(false,400, e.getMessage(),  null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<?> noDataFoundException(NoHandlerFoundException e, WebRequest request){
        log.severe(e.getMessage());
        log.severe(e.getLocalizedMessage());
        Response<?> response = new Response<>(false,404, e.getMessage(),  null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(GeneralServiceException.class)
    public ResponseEntity<?> generalServiceException(GeneralServiceException e, WebRequest request){
        log.severe(e.getMessage());
        log.severe(e.getLocalizedMessage());
        Response<?> response = new Response<>(false,500, "Internal Server Error", null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

