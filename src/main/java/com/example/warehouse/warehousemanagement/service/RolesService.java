package com.example.warehouse.warehousemanagement.service;

import com.example.warehouse.warehousemanagement.repository.RolesRepository;
import com.example.warehouse.warehousemanagement.model.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class RolesService {

  @Autowired RolesRepository rolesRepo;

  // Get all roles
  public List<Roles> getAllRoles() {
    return rolesRepo.findAll();
  }

  // Create Roles
  public Roles createRole(Roles roles) {
    if (rolesRepo.findByroleName(roles.getRoleName()) == null) {
      return rolesRepo.save(roles);
    } else {
      return null;
    }
  }

  // Delete Roles
  public boolean deleteRoles(String name) {
    Roles role = rolesRepo.findByroleName(name);
    if (role.getId() != null) {
      rolesRepo.deleteById(role.getId());
      return true;
    } else {
      return false;
    }
  }
}
