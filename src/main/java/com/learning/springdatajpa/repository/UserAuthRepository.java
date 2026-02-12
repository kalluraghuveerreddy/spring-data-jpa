package com.learning.springdatajpa.repository;

import com.learning.springdatajpa.security.UserAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthRepository extends JpaRepository<UserAuthEntity,Long> {

    Optional<UserAuthEntity> findByUsername(String username);
}
