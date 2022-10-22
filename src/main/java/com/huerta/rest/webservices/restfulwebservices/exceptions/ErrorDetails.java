package com.huerta.rest.webservices.restfulwebservices.exceptions;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class ErrorDetails {

  public ErrorDetails(LocalDateTime timestamp, String message, String details) {
    this.timestamp = timestamp;
    this.message = message;
    this.details = details;
  }

  private LocalDateTime timestamp;
  private String message;
  private String details;
}
