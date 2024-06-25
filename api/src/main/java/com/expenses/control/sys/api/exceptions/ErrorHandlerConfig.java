package com.expenses.control.sys.api.exceptions;

import com.expenses.control.sys.api.exceptions.NoDataFoundException;
import com.expenses.control.sys.api.exceptions.ValidateServiceException;
import com.expenses.control.sys.api.util.WrapperResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ErrorHandlerConfig extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> all (Exception e, WebRequest request){
        log.error(e.getMessage(),e);
        WrapperResponse<?> response = new WrapperResponse<>(false,"Internal Server Error",null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(ValidateServiceException.class)
    public ResponseEntity<?> validateService (ValidateServiceException e, WebRequest request){
        log.info(e.getMessage(),e);
        WrapperResponse<?> response = new WrapperResponse<>(false, e.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<?> noDatafound (NoDataFoundException e, WebRequest request){
        log.info(e.getMessage(),e);
        WrapperResponse<?> response = new WrapperResponse<>(false, e.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(GeneralServiceException.class)
    public ResponseEntity<?> generalService (GeneralServiceException e, WebRequest request){
        log.error(e.getMessage(),e);
        WrapperResponse<?> response = new WrapperResponse<>(false, "Internal Server Error", null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
