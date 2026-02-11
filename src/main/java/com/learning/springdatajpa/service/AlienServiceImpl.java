package com.learning.springdatajpa.service;

import com.learning.springdatajpa.dto.RequestAlienDto;
import com.learning.springdatajpa.dto.ResponseAlienDto;
import com.learning.springdatajpa.entity.Alien;
import com.learning.springdatajpa.mapper.ALienMapper;
import com.learning.springdatajpa.repository.AlienRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AlienServiceImpl implements IAlienService {

    private AlienRepository alienRepository;

    @Override
    public Long saveAlien(RequestAlienDto alienDto) {
        Alien alien = ALienMapper.transformToAlien(alienDto);
        Alien savedAlien = alienRepository.save(alien);
        return savedAlien.getAlienId();
    }

    @Override
    public ResponseAlienDto getAlien(Long id) {
        Alien alien = alienRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Alien Nor Found with :" + id));
        return ALienMapper.transformToAlienResponse(alien);
    }

    @Override
    public List<ResponseAlienDto> getAllAliens() {
        List<Alien> aliens = alienRepository.findAll();
        return aliens.stream().map(ALienMapper::transformToAlienResponse)
                .collect(Collectors.toList());
    }
}
