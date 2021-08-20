package com.nathan.pet.PomofocusClone.api.controllers;

import com.nathan.pet.PomofocusClone.api.exceptions.TemplateNotFoundException;
import com.nathan.pet.PomofocusClone.api.models.Task;
import com.nathan.pet.PomofocusClone.api.models.Template;
import com.nathan.pet.PomofocusClone.api.models.User;
import com.nathan.pet.PomofocusClone.api.repositories.TaskRepository;
import com.nathan.pet.PomofocusClone.api.repositories.TemplateRepository;
import com.nathan.pet.PomofocusClone.api.repositories.UserRepository;
import org.apache.juli.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TemplateController {
  private TemplateRepository repository;
  private UserRepository userRepository;
  private TaskRepository taskRepository;

  public TemplateController(TemplateRepository repository, UserRepository userRepository, TaskRepository taskRepository) {
    this.repository = repository;
    this.userRepository = userRepository;
    this.taskRepository = taskRepository;
  }

  @PostMapping("/add-template")
  public ResponseEntity<?> createTemplate(@RequestParam String name,@Valid @RequestBody Template template) {
    User user = userRepository.findByUsername(name);
    if (user == null) return ResponseEntity.badRequest().build();
    List<Template> templateList = user.getTemplates();
    templateList.add(template);
    template.setUser(user);

    List<Task> taskList = user.getTasks();
    List<Task> newTasks = new ArrayList<>();
    taskList.forEach((task) -> {
      Task copyTask = new Task(task);
      copyTask.setTemplate(template);
      taskRepository.save(copyTask);
      newTasks.add(copyTask);
    });
    template.setTasks(newTasks);

    repository.save(template);
    return ResponseEntity.status(201).build();
  }

  @DeleteMapping("/templateList/remove")
  public ResponseEntity<?> removeTemplate(@RequestParam Long id) {
    Template template = repository.findById(id).orElseThrow(() -> new TemplateNotFoundException(id));
    List<Task> tasks = template.getTasks();
    tasks.forEach((item) -> {
      taskRepository.delete(item);
    });
    repository.delete(template);
    return ResponseEntity.noContent().build();
  }
}
