package com.learning.springdatajpa.service;

import com.learning.springdatajpa.dto.RequestAlienDto;
import com.learning.springdatajpa.dto.ResponseAlienDto;

import java.util.List;

public interface IAlienService {

    Long saveAlien(RequestAlienDto alienDto);
    ResponseAlienDto getAlien(Long id);
    List<ResponseAlienDto> getAllAliens();
    List<ResponseAlienDto> findAliensByAge(int age);
    ResponseAlienDto findAliensByAgeAndName(int age, String name);
}
