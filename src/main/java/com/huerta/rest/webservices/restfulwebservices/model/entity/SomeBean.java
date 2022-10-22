package com.huerta.rest.webservices.restfulwebservices.model.entity;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
// @JsonIgnoreProperties("field1")
public class SomeBean {

  private String field1;

//   @JsonIgnore
  private String field2;

  private String field3;

  public SomeBean(String string, String string2, String string3) {
    this.field1 = string;
    this.field2 = string2;
    this.field3 = string3;
  }
}
