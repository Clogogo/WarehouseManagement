package com.example.warehouse.warehousemanagement.repository;

import com.example.warehouse.warehousemanagement.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long>, JpaSpecificationExecutor<Roles> {
    Roles findByroleName(String name );
}