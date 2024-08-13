package com.yezebi.pinpin.kaizoku.repository;

import com.yezebi.pinpin.kaizoku.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
  @Nullable
  User findByEmailIgnoreCase(String email);

  boolean existsByEmailIgnoreCase(String email);
}
