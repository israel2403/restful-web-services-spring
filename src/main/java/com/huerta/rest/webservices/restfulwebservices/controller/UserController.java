package com.huerta.rest.webservices.restfulwebservices.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.huerta.rest.webservices.restfulwebservices.dao.UserDao;
import com.huerta.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;
import com.huerta.rest.webservices.restfulwebservices.model.entity.User;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

  private final UserDao userDao;

  @RequestMapping
  public List<User> getAllUsers() {
    return this.userDao.findAll();
  }

  @GetMapping("{id}")
  public EntityModel<User> getById(@PathVariable final Integer id) {
    User userById = this.userDao.getById(id);
    if (userById == null) {
      throw new UserNotFoundException("id" + id);
    }
    EntityModel<User> entityModel = EntityModel.of(userById);

    WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
    entityModel.add(link.withRel("all-users"));

    return entityModel;
  }

  @PostMapping
  public ResponseEntity<User> save(@Valid @RequestBody User user) {
    User newUser = this.userDao.saveUser(user);
    URI location = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(newUser.getId())
      .toUri();
    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable final Integer id) {
    this.userDao.deleteById(id);
  }
}
