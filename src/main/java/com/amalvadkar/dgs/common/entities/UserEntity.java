package com.amalvadkar.dgs.common.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity extends AbstractBaseEntity {

  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @Column(name = "email", nullable = false, length = 50, unique = true)
  private String email;

  @Column(name = "last_login_time")
  private Instant lastLoginTime;

  @Column(name="active", nullable = false)
  private boolean active;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "role_id", nullable = false)
  private RoleEntity roleEntity;

}