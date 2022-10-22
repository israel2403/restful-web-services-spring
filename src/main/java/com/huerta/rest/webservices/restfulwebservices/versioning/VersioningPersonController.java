package com.huerta.rest.webservices.restfulwebservices.versioning;

import com.huerta.rest.webservices.restfulwebservices.model.entity.Name;
import com.huerta.rest.webservices.restfulwebservices.model.entity.PersonV1;
import com.huerta.rest.webservices.restfulwebservices.model.entity.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

  @GetMapping(value = "/v1/person")
  public PersonV1 getFirstVersionOfPerson() {
    return new PersonV1("Bob Charlie");
  }

  @GetMapping(value = "/v2/person")
  public PersonV2 getSecondVersionOfPerson() {
    return new PersonV2(new Name("Israel", "Huerta"));
  }

  @GetMapping(path = "person", params = "version=1")
  public PersonV1 getFirstVersionOfRequestParameter() {
    return new PersonV1("Bob Charlie");
  }
  
  @GetMapping(path = "person", params = "version=2")
  public PersonV2 geSecondVersionOfRequestParameter() {
    return new PersonV2(new Name("Israel", "Huerta"));
  }
  @GetMapping(path = "persons/header", headers  = "X-API-VERSION=1")
  public PersonV1 getFirstVersionOfRequestHeader() {
    return new PersonV1("Bob Charlie");
  }
  @GetMapping(path = "persons/header", headers = "X-API-VERSION=2")
  public PersonV2 getSecondVersionOfRequestHeader() {
    return new PersonV2(new Name("Israel", "Huerta"));
  }
  @GetMapping(path = "persons/accept", produces   = "application/vnd.company.app-v1+json")
  public PersonV1 getFirstVersionOfAcceptHeader() {
    return new PersonV1("Bob Charlie");
  }
  @GetMapping(path = "persons/accept", produces   = "application/vnd.company.app-v2+json")
  public PersonV2 getSecondVersionOfAcceptHeader() {
    return new PersonV2(new Name("Israel", "Huerta"));
  }
}
