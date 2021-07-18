package com.nathan.pet.PomofocusClone.api.controllers;

import com.nathan.pet.PomofocusClone.api.assemblers.UserModelAssembler;
import com.nathan.pet.PomofocusClone.api.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.Entity;

@Entity
public class AuthController {
  private UserRepository repository;
  private UserModelAssembler assembler;

  public AuthController(UserRepository repository, UserModelAssembler assembler) {
    this.repository = repository;
    this.assembler = assembler;
  }

  @PostMapping("/user/login")
  public ResponseEntity<?> login(@RequestBody String email, @RequestBody String password) {
    //TODO: implement authentication for user
    return null;
  }

  public ResponseEntity<?> register(@RequestBody String name, @RequestBody String email, @RequestBody String password) {
    // TODO: implement register and validation for register
    return null;
  }
}
