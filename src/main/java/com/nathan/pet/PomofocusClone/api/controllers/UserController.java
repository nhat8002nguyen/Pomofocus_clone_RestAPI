package com.nathan.pet.PomofocusClone.api.controllers;

import com.nathan.pet.PomofocusClone.api.assemblers.UserModelAssembler;
import com.nathan.pet.PomofocusClone.api.exceptions.UserNotFoundException;
import com.nathan.pet.PomofocusClone.api.models.User;
import com.nathan.pet.PomofocusClone.api.repositories.UserRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
  private UserRepository repository;
  private UserModelAssembler assembler;

  public UserController(UserRepository repository, UserModelAssembler assembler) {
    this.repository = repository;
    this.assembler = assembler;
  }

  @GetMapping("/users")
  public CollectionModel<EntityModel<User>> all() {
    List<EntityModel<User>> userModels  = repository.findAll().stream()
        .map(assembler::toModel)
        .collect(Collectors.toList());

    return CollectionModel.of(userModels,
        linkTo(methodOn(UserController.class).all()).withSelfRel());
  }

  @GetMapping("/users/{id}")
  public EntityModel<User> one(@PathVariable Long id) {
    User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));

    return assembler.toModel(user);
  }

  @DeleteMapping("users/{id}")
  public ResponseEntity<EntityModel<User>> delete(@PathVariable Long id) {
    repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    repository.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
