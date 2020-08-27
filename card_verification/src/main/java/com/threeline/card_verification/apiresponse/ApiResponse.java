package com.threeline.card_verification.apiresponse;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

/**
 * ApiResponse
 */
public class ApiResponse<T> {

  private HttpStatus status;
  private String message;
  private String error;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private LocalDateTime timestamp;
  private T data;

  private ApiResponse() {
    timestamp = LocalDateTime.now();
  }

  public ApiResponse(HttpStatus status) {
    this();
    this.status = status;
  }

  public ApiResponse(HttpStatus status, String message) {
    this();
    this.status = status;
    this.message = message;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

}