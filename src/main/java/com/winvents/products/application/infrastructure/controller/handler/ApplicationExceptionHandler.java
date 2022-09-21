package com.winvents.products.application.infrastructure.controller.handler;

import com.winvents.products.application.infrastructure.dto.error.ErrorMessage;
import com.winvents.products.application.infrastructure.dto.error.ErrorResponse;
import com.winvents.products.application.infrastructure.exception.DatabaseFieldException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DatabaseFieldException.class)
    public ErrorResponse handleDatabaseFieldExceptions(DatabaseFieldException ex) {

        ErrorResponse errorResponse = new ErrorResponse();

        String path = ex.getName();
        String message = ex.getMessage();
        errorResponse.getErrors().add(new ErrorMessage(path, message));

        return errorResponse;

    }

}
