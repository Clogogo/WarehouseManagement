package com.example.warehouse.warehousemanagement.controller;

import com.example.warehouse.warehousemanagement.model.Role;
import com.example.warehouse.warehousemanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {

  @Autowired
  RoleService roleService;


  // Get all Roles
  @GetMapping(value = "/role")
  public ResponseEntity<List<Role>> getAllRole() {
    List<Role> getAllRole = roleService.getAllRole();

    if (getAllRole.size() > 0) {
      return new ResponseEntity<>(getAllRole, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(getAllRole, HttpStatus.NO_CONTENT);
    }
  }

  // Add Roles
  @PostMapping(value = "/role")
  public ResponseEntity<Role> addRoles (@RequestBody Role role) {
    Role result = roleService.createRole(role);
    if (result != null) {
      return new ResponseEntity<>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  // Delete Roles
  @DeleteMapping(value = "/role/{name}")
  public ResponseEntity<?> deleteRole (@PathVariable String name) {
    if (roleService.deletedRole(name)) {
      return new ResponseEntity<>("Role Deleted", HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
