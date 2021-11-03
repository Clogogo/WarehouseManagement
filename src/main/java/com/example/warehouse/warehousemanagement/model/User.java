package com.example.warehouse.warehousemanagement.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "user")
public class User {
  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "first_name", nullable = false)
  private String userFirstName;

  @Column(name = "last_name", nullable = false)
  private String userLastName;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "pass_active", nullable = false)
  private String passwordActiveDays;

  @Column(name = "userId", nullable = false)
  private String userId;

  @Column(name = "email", nullable = false)
  private String EmailAddress;

  @Column(name = "lang", nullable = false)
  private String Language;
}
