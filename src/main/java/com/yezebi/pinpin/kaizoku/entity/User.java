package com.yezebi.pinpin.kaizoku.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User extends Auditable {
  @Id private String id;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String name;
}
