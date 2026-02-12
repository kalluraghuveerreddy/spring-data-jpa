package com.learning.springdatajpa.controller;

import com.learning.springdatajpa.dto.RequestAlienDto;
import com.learning.springdatajpa.dto.ResponseAlienDto;
import com.learning.springdatajpa.repository.UserAuthRepository;
import com.learning.springdatajpa.security.UserAuthEntity;
import com.learning.springdatajpa.service.IAlienService;
import com.learning.springdatajpa.service.UserAuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aliens")
@AllArgsConstructor
public class AlienController {
    private final UserAuthService userAuthService;
    private IAlienService alienService;
    private UserAuthRepository userAuthRepository;

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
    @GetMapping("/readByAge/{age}")
    public ResponseEntity<?> findAliensByAge(@PathVariable int age){
        List<ResponseAlienDto> responseAlienDto = alienService.findAliensByAge(age);
        return ResponseEntity.status(HttpStatus.OK).body(responseAlienDto);
    }
    @GetMapping("/readBy/{age}/{name}")
    public ResponseEntity<?> findAliensByAgeAndName(
            @PathVariable int age,
            @PathVariable String name){

        ResponseAlienDto responseAlienDto = alienService.findAliensByAgeAndName(age, name);
        return ResponseEntity.status(HttpStatus.OK).body(responseAlienDto);

    }
    @PostMapping("/enroll")
    public ResponseEntity<?> enrollUser(@RequestBody UserAuthEntity userAuthEntity) {
        userAuthService.save(userAuthEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("User has been enrolled");
    }

}
