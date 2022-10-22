package com.huerta.rest.webservices.restfulwebservices.model.entity;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PersonV1 {

  private String name;

  public PersonV1(final String name) {
    this.name = name;
  }
}
