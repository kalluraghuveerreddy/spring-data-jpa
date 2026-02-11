package com.learning.springdatajpa.repository;

import com.learning.springdatajpa.entity.Alien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlienRepository extends JpaRepository<Alien,Long> {
}
