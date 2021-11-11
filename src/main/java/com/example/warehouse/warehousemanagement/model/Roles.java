package com.example.warehouse.warehousemanagement.model;

import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Locale;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "roles")
public class Roles {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name", nullable = false)
  private String roleName;

  @Column(name = "time_created", nullable = false)
  private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

  public void setRoleName(String roleName) {
    this.roleName = roleName.toLowerCase();
  }
}
