package com.learning.springdatajpa.repository;

import com.learning.springdatajpa.entity.Alien;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AlienRepository extends JpaRepository<Alien, Long> {

    @Query("SELECT a from Alien a where a.alienAge= ?1")
    List<Alien> findAliensByAge(int age);

    @Query("SELECT a from Alien a where a.alienAge= ?1 and a.alienName= ?2")
    Optional<Alien> findByAlienAgeAndAlienName(int age, String name);

    List<Alien> findAliensByAlienAgeGreaterThan(int age, Pageable pageable);

    List<Alien> findAliensByAlienAgeLessThan(int age);
}
