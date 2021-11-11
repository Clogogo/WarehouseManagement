package com.example.warehouse.warehousemanagement.service;

import com.example.warehouse.warehousemanagement.model.User;
import com.example.warehouse.warehousemanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;

  // get all
  /**
   * Get all user and return list of all user
   *
   * @param:
   */
  public List<User> getAllUser() {
    return userRepository.findAll();
  }

  // get user by id
  /**
   * Get user by id and user
   *
   * @param: userId
   */
  public Optional<User> getUserById(Long id) {
    return userRepository.findById(id);
  }

  /**
   * create user and return user
   *
   * @param: user body
   */
  public User addUser(User user) {
    return userRepository.save(user);
  }

  /**
   * update user by id
   *
   * @param: user body
   */
  public User updateUser(User user) {
    if (userRepository.findById(user.getId()).isPresent()) {
      return userRepository.save(user);
    } else {
      return null;
    }
  }

  /**
   * delete user by id
   *
   * @param: userId
   */
  public boolean deleteUser(Long id) {

    if (userRepository.findById(id).isPresent()) {
      userRepository.deleteById(id);
      return true;
    }
    return false;
  }

  /**
   * deactivate user by id
   *
   * @param: userId
   */
  public boolean deactivateUser(Long id) {
    Optional<User> userData = userRepository.findById(id);
    if (userData.isPresent()) {
      userData.get().setActive(0);
      userRepository.save(userData.get());
      return true;
    }
    else {
      return false;
    }
  }
}
