package com.nathan.pet.PomofocusClone.api.exceptions;

public class SettingNotFoundException extends RuntimeException {
  public SettingNotFoundException(Long id) { super("Could not found setting with id " + id); }
}
