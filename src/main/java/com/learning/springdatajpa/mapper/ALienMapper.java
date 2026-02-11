package com.learning.springdatajpa.mapper;

import com.learning.springdatajpa.dto.RequestAlienDto;
import com.learning.springdatajpa.dto.ResponseAlienDto;
import com.learning.springdatajpa.entity.Alien;

public class ALienMapper {

    public static ResponseAlienDto transformToAlienResponse(Alien alien) {
        ResponseAlienDto alienDto = new ResponseAlienDto();
        alienDto.setAlienId(alien.getAlienId());
        alienDto.setAlienName(alien.getAlienName());
        alienDto.setAlienAge(alien.getAlienAge());
        return alienDto;
    }

    public static Alien transformToAlien(RequestAlienDto alienDto) {
        Alien alien = new Alien();
        alien.setAlienName(alienDto.getAlienName());
        alien.setAlienAge(alienDto.getAlienAge());
        return alien;
    }
}
