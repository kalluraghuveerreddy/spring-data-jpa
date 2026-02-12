package com.learning.springdatajpa.service;

import com.learning.springdatajpa.dto.RequestAlienDto;
import com.learning.springdatajpa.dto.ResponseAlienDto;
import com.learning.springdatajpa.entity.Alien;
import com.learning.springdatajpa.mapper.ALienMapper;
import com.learning.springdatajpa.repository.AlienRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        Pageable pageable = PageRequest.of(0, 10, Sort.by(
                Sort.Order.desc("alienName"),
                Sort.Order.asc("alienAge")
        ));
        List<Alien> aliens = alienRepository.findAliensByAlienAgeGreaterThan(20, pageable);
        return aliens.stream().map(ALienMapper::transformToAlienResponse)
                .collect(Collectors.toList());

    }

    public List<ResponseAlienDto> findAliensByAge(int age) {
        List<Alien> aliens;
        aliens = alienRepository.findAliensByAge(age);
        return aliens.stream().map(ALienMapper::transformToAlienResponse)
                .collect(Collectors.toList());

    }

    @Override
    public ResponseAlienDto findAliensByAgeAndName(int age, String name) {
        Optional<Alien> optionalAlien = alienRepository.findByAlienAgeAndAlienName(age, name);

        if (optionalAlien.isPresent()) {
            Alien alien = optionalAlien.get();
            return ALienMapper.transformToAlienResponse(alien);
        }
        return null;
    }
}
