package br.com.szella.memoteca.exception;

import br.com.szella.memoteca.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class CustomControllerExceptionHandler {

    @ExceptionHandler(DBException.class)
    protected ResponseEntity<ErrorResponse> handleDBException(DBException exception) {
        return generatePayload(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ApplicationException.class)
    protected ResponseEntity<ErrorResponse> handleApplicationException(ApplicationException exception) {
        return generatePayload(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleApplicationException(MethodArgumentNotValidException exception) {

        var camposComErro = exception.getBindingResult().getFieldErrors().stream()
                .map(f -> Map.of("campo", f.getField(),
                        "erro", Objects.requireNonNull(f.getDefaultMessage())))
                .toList();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(camposComErro);
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
