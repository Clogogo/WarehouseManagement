package com.example.warehouse.warehousemanagement.controller;

import com.example.warehouse.warehousemanagement.model.Roles;
import com.example.warehouse.warehousemanagement.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RolesController {

  @Autowired RolesService roleService;


  // Get all Roles
  @GetMapping(value = "/roles")
  public ResponseEntity<Collection<Roles>> getAllUsers() {
    List<Roles> getAllRoles = roleService.getAllRoles();

    if (getAllRoles.size() > 0) {
      return new ResponseEntity<>(getAllRoles, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(getAllRoles, HttpStatus.NO_CONTENT);
    }
  }

  // Add Roles
  @PostMapping(value = "/roles")
  public ResponseEntity<Roles> addUser(@RequestBody Roles roles) {
    Roles result = roleService.createRole(roles);
    if (result != null) {
      return new ResponseEntity<>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  // Delete Roles
  @DeleteMapping(value = "/roles/{name}")
  public ResponseEntity<Collection<Roles>> deleteUser(@PathVariable String name) {
    if (roleService.deleteRoles(name)) {
      return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
