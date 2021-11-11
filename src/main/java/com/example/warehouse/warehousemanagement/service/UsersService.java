package com.example.warehouse.warehousemanagement.service;

import com.example.warehouse.warehousemanagement.repository.UsersRepository;
import com.example.warehouse.warehousemanagement.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
  @Autowired UsersRepository usersRepo;

  // get all
  /**
   * Get all user and return list of all user
   *
   * @param:
   */
  public List<Users> getAllUsers() {
    return usersRepo.findAll();
  }

  // get user by id
  /**
   * Get user by id and user
   *
   * @param: userId
   */
  public Optional<Users> getUserById(Long id) {
    return usersRepo.findById(id);
  }

  /**
   * create user and return user
   *
   * @param: user body
   */
  public Users addUser(Users user) {
    return usersRepo.save(user);
  }

  /**
   * update user by id
   *
   * @param: user body
   */
  public Users updateUser(Users user) {
    if (usersRepo.findById(user.getId()).isPresent()) {
      return usersRepo.save(user);
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

    if (usersRepo.findById(id).isPresent()) {
      usersRepo.deleteById(id);
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
    Optional<Users> userData = usersRepo.findById(id);
    if (userData.isPresent()) {
      userData.get().setActive(0);
      usersRepo.save(userData.get());
      return true;
    }
    else {
      return false;
    }
  }
}
