package com.dynamodb.adapter.in.advice;

import com.dynamodb.adapter.dto.RetornoPadronizado;
import com.dynamodb.commons.exception.RepositoryException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(RepositoryException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public RetornoPadronizado handleRepositoryException(Exception e) {

    return new RetornoPadronizado(String.valueOf(HttpStatus.NOT_FOUND), e.getMessage());
  }
}