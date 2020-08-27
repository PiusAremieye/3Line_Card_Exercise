package com.threeline.card_verification.configurations;

import com.threeline.card_verification.apiresponse.ApiResponse;
import com.threeline.card_verification.exception.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * ResponseExceptionHandler
 */
@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<Object> handleCustomException(CustomException ce) {
    ApiResponse<?> ar = new ApiResponse<>(ce.getStatus());
    ar.setError(ce.getMessage());
    return buildResponseEntity(ar);
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<Object> handleCustomException(MethodArgumentTypeMismatchException ce) {
    ApiResponse<?> ar = new ApiResponse<>(HttpStatus.BAD_REQUEST);
    ar.setError("Invalid card number");
    return buildResponseEntity(ar);
  }

  private ResponseEntity<Object> buildResponseEntity(ApiResponse<?> apiResponse) {
    return new ResponseEntity<>(apiResponse, apiResponse.getStatus());
  }
}