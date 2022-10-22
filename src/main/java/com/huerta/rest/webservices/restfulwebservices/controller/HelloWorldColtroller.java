package com.huerta.rest.webservices.restfulwebservices.controller;

import com.huerta.rest.webservices.restfulwebservices.model.dto.HelloWorldBeanDTO;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello-world")
@RequiredArgsConstructor
public class HelloWorldColtroller {

  private final MessageSource messageSource;

  @GetMapping
  public ResponseEntity<String> helloWorld() {
    return ResponseEntity.ok("Hello World");
  }

  @GetMapping("bean")
  public ResponseEntity<HelloWorldBeanDTO> helloWorldBean() {
    return ResponseEntity.ok(new HelloWorldBeanDTO("Hello World"));
  }

  @GetMapping("path-variable/{name}")
  public ResponseEntity<HelloWorldBeanDTO> helloWorldPathVariable(
    @PathVariable(name = "name") final String name
  ) {
    return ResponseEntity.ok(
      new HelloWorldBeanDTO(String.format("Hello World, %s", name))
    );
  }

  @GetMapping("hello-world-internationalized")
  public ResponseEntity<String> helloWorldInternationalized() {
    Locale locale = LocaleContextHolder.getLocale();
    return ResponseEntity.ok(
      messageSource.getMessage(
        "good.monrning.message",
        null,
        "Default Message",
        locale
      )
    );
  }
}
