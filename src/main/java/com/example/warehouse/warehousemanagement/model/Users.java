package com.example.warehouse.warehousemanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class Users {
  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "first_name", nullable = false)
  private String userFirstName;

  @Column(name = "last_name", nullable = false)
  private String userLastName;

  @Column(name = "active", nullable = false)
  private Integer active = 1;


  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private Roles role;

//  @Column(name = "password", nullable = false)
//  private String password;
//
//  @Column(name = "pass_active", nullable = false)
//  private String passwordActiveDays;
//
//  @Column(name = "userId", nullable = false)
//  private String userId;
//
//  @Column(name = "email", nullable = false)
//  private String EmailAddress;
//
//  @Column(name = "lang", nullable = false)
//  private String Language;

}
