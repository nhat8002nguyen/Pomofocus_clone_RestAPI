package com.nathan.pet.PomofocusClone.api.controllers;

import com.nathan.pet.PomofocusClone.api.exceptions.SettingNotFoundException;
import com.nathan.pet.PomofocusClone.api.models.Setting;
import com.nathan.pet.PomofocusClone.api.models.User;
import com.nathan.pet.PomofocusClone.api.repositories.SettingRepository;
import com.nathan.pet.PomofocusClone.api.repositories.UserRepository;
import net.minidev.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class SettingController {
  private final SettingRepository repository;

  public SettingController(SettingRepository repository) {
    this.repository = repository;
  }
}
