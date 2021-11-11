package com.example.warehouse.warehousemanagement.service;

import com.example.warehouse.warehousemanagement.repository.RoleRepository;
import com.example.warehouse.warehousemanagement.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class RoleService {

  @Autowired
  RoleRepository roleRepository;

  // Get all role
  public List<Role> getAllRole() {
    return roleRepository.findAll();
  }

  // Create Roles
  public Role createRole(Role role) {
    if (roleRepository.findByroleName(role.getRoleName()) == null) {
      return roleRepository.save(role);
    } else {
      return null;
    }
  }

  // Delete Roles
  public boolean deletedRole(String name) {
    Role role = roleRepository.findByroleName(name);
    if (role.getId() != null) {
      roleRepository.deleteById(role.getId());
      return true;
    } else {
      return false;
    }
  }
}
