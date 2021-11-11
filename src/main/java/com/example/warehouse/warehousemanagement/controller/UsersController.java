package com.example.warehouse.warehousemanagement.controller;

import com.example.warehouse.warehousemanagement.model.Users;
import com.example.warehouse.warehousemanagement.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UsersController {

  @Autowired private UsersService usersService;

  // Get all users
  @GetMapping(value = "/users")
  public ResponseEntity<Collection<Users>> getAllUsers() {
    List<Users> getAllUsers = usersService.getAllUsers();
    if (getAllUsers.size() > 0) {
      return new ResponseEntity<>(getAllUsers, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(getAllUsers, HttpStatus.NO_CONTENT);
    }
  }

  // Get user by id
  @GetMapping(value = "/user/{id}")
  public ResponseEntity<Users> getUserById(@PathVariable Long id) {
    Optional<Users> getUserById = usersService.getUserById(id);
    return getUserById
        .map(user -> ResponseEntity.ok().body(user))
        .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
  }

  // Add user
  @PostMapping(value = "/user")
  public ResponseEntity<Users> addUser(@RequestBody Users users) {
    Users user = usersService.addUser(users);
    try {
      return ResponseEntity.ok().body(user);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
  }

  // Update User
  @PutMapping(value = "/update")
  public ResponseEntity<Users> updateUser(@RequestBody Users users) {
    Users user = usersService.updateUser(users);
    if (user != null) {
      return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
  }

  // Delete user
  @DeleteMapping(value = "/users/{id}")
  public ResponseEntity<Collection<Users>> deleteUser(@PathVariable Long id) {
    if (usersService.deleteUser(id)) {
      return new ResponseEntity<>(usersService.getAllUsers(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // Deactivate User
  @PutMapping(value = "/deactivate/{id}")
  public ResponseEntity<Users> deactivateUser(@PathVariable Long id) {
    if (usersService.deactivateUser(id)) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
