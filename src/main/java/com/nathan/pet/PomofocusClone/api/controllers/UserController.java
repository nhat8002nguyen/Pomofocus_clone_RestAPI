package com.nathan.pet.PomofocusClone.api.controllers;

import com.nathan.pet.PomofocusClone.api.exceptions.SettingNotFoundException;
import com.nathan.pet.PomofocusClone.api.exceptions.UserNotFoundException;
import com.nathan.pet.PomofocusClone.api.helpers.ErrorMessage;
import com.nathan.pet.PomofocusClone.api.helpers.ISODate;
import com.nathan.pet.PomofocusClone.api.models.Setting;
import com.nathan.pet.PomofocusClone.api.models.User;
import com.nathan.pet.PomofocusClone.api.repositories.UserRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
public class UserController {
  private final UserRepository repository;
  @Autowired
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public UserController(UserRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.repository = repository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@Valid @RequestBody User user) {
    User checkingUser = repository.findByUsername(user.getName());
    if (checkingUser != null) return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(ErrorMessage.create("message", "User name is already exist"));

    checkingUser = repository.findByGmail(user.getGmail());
    if (checkingUser != null) return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(ErrorMessage.create("message", "Gmail is already exist"));

    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

    repository.save(user);
    return ResponseEntity.status(201).body(user);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach(error -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    return errors;
  }

}
