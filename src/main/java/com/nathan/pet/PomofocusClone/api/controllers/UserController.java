package com.nathan.pet.PomofocusClone.api.controllers;

import com.nathan.pet.PomofocusClone.api.assemblers.UserModelAssembler;
import com.nathan.pet.PomofocusClone.api.exceptions.UserNotFoundException;
import com.nathan.pet.PomofocusClone.api.models.User;
import com.nathan.pet.PomofocusClone.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

@RequestMapping("/api")
@RestController
public class UserController {
  private final UserRepository repository;
  private final UserModelAssembler assembler;
  @Autowired
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public UserController(UserRepository repository, UserModelAssembler assembler,
                        BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.repository = repository;
    this.assembler = assembler;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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

  @DeleteMapping("/users/{id}")
  public ResponseEntity<EntityModel<User>> delete(@PathVariable Long id) {
    repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    repository.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/user/register")
  public ResponseEntity<?> register(@RequestParam String email, @RequestParam String username,
                                                    @RequestParam String password) {
    User user = new User();
    user.setPassword(bCryptPasswordEncoder.encode(password));
    user.setGmail(email);
    user.setName(username);

    // create date time
    TimeZone tz = TimeZone.getTimeZone("UTC");
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
    df.setTimeZone(tz);
    String nowAsISO = df.format(new Date());
    user.setCreatedAt(nowAsISO);
    user.setUpdatedAt(nowAsISO);

    repository.save(user);
    return ResponseEntity.status(201).body(user);
  }
}
