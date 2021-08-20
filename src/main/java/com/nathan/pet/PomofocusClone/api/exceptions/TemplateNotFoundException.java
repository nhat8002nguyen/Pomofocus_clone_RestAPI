package com.nathan.pet.PomofocusClone.api.exceptions;

public class TemplateNotFoundException extends RuntimeException {
  public TemplateNotFoundException(Long id) { super("Could not found setting with id " + id); }
}
