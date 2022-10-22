package com.huerta.rest.webservices.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(
  basePackages = { "com.huerta.rest.webservices.restfulwebservices" }
)
public class RestfulWebServicesApplication {

  public static void main(String[] args) {
    SpringApplication.run(RestfulWebServicesApplication.class, args);
  }
}
