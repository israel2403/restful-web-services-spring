package com.huerta.rest.webservices.restfulwebservices.controller;

import com.huerta.rest.webservices.restfulwebservices.model.entity.SomeBean;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("filtering")
public class FilteringController {

  @GetMapping
  public SomeBean filtering() {
    return new SomeBean("value1", "value2", "value3");
  }

  @GetMapping("list")
  public List<SomeBean> getAll() {
    return Arrays.asList(
      new SomeBean("value1", "value2", "value3"),
      new SomeBean("value4", "value4", "value5")
    );
  }
}
