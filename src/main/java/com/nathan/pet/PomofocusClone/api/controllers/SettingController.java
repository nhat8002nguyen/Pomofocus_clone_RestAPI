package com.nathan.pet.PomofocusClone.api.controllers;

import com.nathan.pet.PomofocusClone.api.repositories.SettingRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class SettingController {
  private final SettingRepository repository;

  public SettingController(SettingRepository repository) {
    this.repository = repository;
  }
}
