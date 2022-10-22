package com.huerta.rest.webservices.restfulwebservices.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class HelloWorldBeanDTO {

  private final String message;
}
