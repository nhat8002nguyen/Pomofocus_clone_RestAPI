package com.nathan.pet.PomofocusClone.api.controllers;

import com.nathan.pet.PomofocusClone.api.exceptions.SettingNotFoundException;
import com.nathan.pet.PomofocusClone.api.exceptions.UserNotFoundException;
import com.nathan.pet.PomofocusClone.api.helpers.ErrorMessage;
import com.nathan.pet.PomofocusClone.api.helpers.ISODate;
import com.nathan.pet.PomofocusClone.api.models.Setting;
import com.nathan.pet.PomofocusClone.api.models.User;
import com.nathan.pet.PomofocusClone.api.repositories.SettingRepository;
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
  private final SettingRepository settingRepository;
  @Autowired
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public UserController(UserRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder,
    SettingRepository settingRepository) {
    this.repository = repository;
    this.settingRepository = settingRepository;
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

    // create setting and assign association
    Setting setting = new Setting();
    setting.setUser(user);
    user.setSetting(setting);

    // add CascadeType.ALL to User model to save setting when flush user
    repository.save(user);
    return ResponseEntity.status(201).body(new JSONObject(Map.of("message", "Register successfully !")));
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

  @GetMapping("/user")
  public ResponseEntity<?> getUserId(@RequestParam String name) {
    User user = repository.findByUsername(name);
    if (user == null) return ResponseEntity.badRequest()
        .body(new JSONObject(Map.of("message", "User not found !")));

    return ResponseEntity.ok(new JSONObject(Map.of("id", user.getId())));
  }

  @PostMapping("/resetSetting/{id}")
  public ResponseEntity<?> reset(@PathVariable Long id) {
    User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    Setting oldSetting = user.getSetting();

    Setting setting = new Setting();
    setting.setUser(user);
    user.setSetting(setting);
    settingRepository.deleteById(oldSetting.getId());

    repository.save(user);
    return ResponseEntity.ok(setting);
  }

}
