package com.example.warehouse.warehousemanagement.dao;

import com.example.warehouse.warehousemanagement.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RolesRepository extends JpaRepository<Roles, Long>, JpaSpecificationExecutor<Roles> {
    Roles findByroleName(String name );
}