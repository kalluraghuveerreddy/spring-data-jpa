package com.learning.springdatajpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Alien {

    @Id
    @GeneratedValue
    private Long alienId;
    private String alienName;
    private int alienAge;

}
