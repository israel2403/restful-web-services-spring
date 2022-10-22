package com.huerta.rest.webservices.restfulwebservices.exceptions;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizeResponseEntityExceptionHandler
  extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorDetails> handleAllExceptions(
    Exception ex,
    WebRequest request
  ) {
    ErrorDetails errorDetails = new ErrorDetails(
      LocalDateTime.now(),
      ex.getMessage(),
      request.getDescription(false)
    );
    return new ResponseEntity<ErrorDetails>(
      errorDetails,
      HttpStatus.INTERNAL_SERVER_ERROR
    );
  }

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ErrorDetails> handleUserNotFoundException(
    Exception ex,
    WebRequest request
  ) {
    ErrorDetails errorDetails = new ErrorDetails(
      LocalDateTime.now(),
      ex.getMessage(),
      request.getDescription(false)
    );
    return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
  }

  @Override
  @Nullable
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
    MethodArgumentNotValidException ex,
    HttpHeaders headers,
    HttpStatusCode status,
    WebRequest request
  ) {

    String err = ex.getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.joining(", "));
    ErrorDetails errorDetails = new ErrorDetails(
      LocalDateTime.now(),
      err,
      request.getDescription(false)
    );
    return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
  }
}
