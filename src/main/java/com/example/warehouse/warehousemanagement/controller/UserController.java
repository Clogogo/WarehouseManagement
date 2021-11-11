package com.example.warehouse.warehousemanagement.controller;

import com.example.warehouse.warehousemanagement.model.User;
import com.example.warehouse.warehousemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

  @Autowired private UserService userService;

  // Get all user
  @GetMapping(value = "/user")
  public ResponseEntity<List<User>> getAllUser() {
    List<User> getAllUserDetails = userService.getAllUser();
    if (getAllUserDetails.size() > 0) {
      return new ResponseEntity<>(getAllUserDetails, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(getAllUserDetails, HttpStatus.NO_CONTENT);
    }
  }

  // Get user by id
  @GetMapping(value = "/user/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Long id) {
    Optional<User> getUserById = userService.getUserById(id);
    return getUserById
        .map(user -> ResponseEntity.ok().body(user))
        .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
  }

  // Add user
  @PostMapping(value = "/user")
  public ResponseEntity<User> addUser(@RequestBody User user) {
    User userDetails = userService.addUser(user);
    try {
      return ResponseEntity.ok().body(user);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
  }

  // Update User
  @PutMapping(value = "/update")
  public ResponseEntity<User> updateUser(@RequestBody User user) {
    User userDetails = userService.updateUser(user);
    return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
  }

  // Delete user
  @DeleteMapping(value = "/user/{id}")
  public ResponseEntity deleteUser(@PathVariable Long id) {
    if (userService.deleteUser(id)) {
      return new ResponseEntity<>("User Deleted", HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // Deactivate User
  @PutMapping(value = "/deactivate/{id}")
  public ResponseEntity<User> deactivateUser(@PathVariable Long id) {
    if (userService.deactivateUser(id)) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
