package com.huerta.rest.webservices.restfulwebservices.dao;

import com.huerta.rest.webservices.restfulwebservices.model.entity.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

  private static int usersCount = 0;

  private static List<User> users = new ArrayList<>();

  static {
    users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
    users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
    users.add(new User(++usersCount, "Jim", LocalDate.now().minusYears(20)));
  }

  public List<User> findAll() {
    return users;
  }

  public User getById(final Integer id) {
    return this.findAll()
      .stream()
      .filter(user -> user.getId().equals(id))
      .findFirst()
      .orElse(null);
  }

  public User saveUser(final User user) {
    user.setId(++usersCount);
    this.users.add(user);
    return user;
  }

  public void deleteById(final int id) {
    Predicate<? super User> predicate = user -> user.getId().equals(id);
    users.removeIf(predicate);
  }
}
