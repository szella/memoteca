package br.com.szella.memoteca.exception;

import br.com.szella.memoteca.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerExceptionHandler {

    @ExceptionHandler(DBException.class)
    protected ResponseEntity<ErrorResponse> handleDBException(DBException exception) {
        return generatePayload(exception, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ErrorResponse> generatePayload(Exception exception, HttpStatus httpStatus) {
               return ResponseEntity
                .status(httpStatus)
                .body(
                        ErrorResponse.builder()
                                .message(exception.getMessage())
                                .build()
                );
    }
}
