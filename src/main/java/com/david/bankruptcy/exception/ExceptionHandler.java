package com.david.bankruptcy.exception;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatusCode status, WebRequest request) {

    List<ExceptionField> fields = ex.getBindingResult()
        .getAllErrors()
        .stream()
        .map(error -> (FieldError) error)
        .map(fieldError -> ExceptionField.builder()
            .name(fieldError.getField())
            .message(fieldError.getDefaultMessage())
            .build())
        .collect(Collectors.toList());

    ExceptionBody body = ExceptionBody.builder()
        .status(status.value())
        .timestamp(LocalDateTime.now())
        .message("One or more invalid fields")
        .fields(fields)
        .build();

    return handleExceptionInternal(ex, body, headers, status, request);

  }

}
