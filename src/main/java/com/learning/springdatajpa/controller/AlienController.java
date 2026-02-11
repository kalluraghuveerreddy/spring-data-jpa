package com.learning.springdatajpa.controller;

import com.learning.springdatajpa.dto.RequestAlienDto;
import com.learning.springdatajpa.dto.ResponseAlienDto;
import com.learning.springdatajpa.service.IAlienService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aliens")
@AllArgsConstructor
public class AlienController {
    private IAlienService alienService;

    @PostMapping("/create")
    public ResponseEntity<?> saveAlien(
            @RequestBody RequestAlienDto requestAlienDto) {

        Long alienId = alienService.saveAlien(requestAlienDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(alienId);
    }
    @GetMapping("/read/{id}")
    public ResponseEntity<?> getAliens(@PathVariable Long id) {

        ResponseAlienDto responseAlienDto = alienService.getAlien(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseAlienDto);
    }

    @GetMapping
    public ResponseEntity<?> getAllAliens() {
        List<ResponseAlienDto> allAliens = alienService.getAllAliens();
        return ResponseEntity.status(HttpStatus.OK).body(allAliens);
    }


}
