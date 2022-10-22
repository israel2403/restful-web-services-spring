package com.huerta.rest.webservices.restfulwebservices.model.entity;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

  public User() {}

  public User(Integer id, String name, LocalDate birthDate) {
    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
  }

  private Integer id;

  @Size(min = 2, message = "Name should have at least 2 characters")
  @JsonProperty("user_name")
  private String name;

  @Past(message = "Birthday should be in the past")
  @JsonProperty("birth_day")
  private LocalDate birthDate;
}
