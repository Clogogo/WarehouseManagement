package com.example.warehouse.warehousemanagement.dao;

import com.example.warehouse.warehousemanagement.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}