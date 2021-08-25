package com.nathan.pet.PomofocusClone.api.controllers;

import com.nathan.pet.PomofocusClone.api.exceptions.TemplateNotFoundException;
import com.nathan.pet.PomofocusClone.api.models.Task;
import com.nathan.pet.PomofocusClone.api.models.Template;
import com.nathan.pet.PomofocusClone.api.models.User;
import com.nathan.pet.PomofocusClone.api.repositories.TaskRepository;
import com.nathan.pet.PomofocusClone.api.repositories.TemplateRepository;
import com.nathan.pet.PomofocusClone.api.repositories.UserRepository;
import net.minidev.json.JSONObject;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.logging.Log;

import javax.validation.Valid;
import java.util.*;

@RestController
public class TemplateController {
  private final TemplateRepository repository;
  private final UserRepository userRepository;
  private final TaskRepository taskRepository;
  private final Log log = LogFactory.getLog(this.getClass().getName());

  public TemplateController(TemplateRepository repository, UserRepository userRepository, TaskRepository taskRepository) {
    this.repository = repository;
    this.userRepository = userRepository;
    this.taskRepository = taskRepository;
  }

  @PostMapping("/add-template")
  public ResponseEntity<?> createTemplate(@RequestParam String name, @Valid @RequestBody Template template) {
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
      newTasks.add(copyTask);
    });
    template.setTasks(newTasks);

    repository.save(template);
    return ResponseEntity.status(201).build();
  }

  @DeleteMapping("/templateList/remove")
  public ResponseEntity<?> removeTemplate(@RequestParam Long id) {
    Template template = repository.findById(id).orElseThrow(() -> new TemplateNotFoundException(id));
    repository.delete(template);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/append-template/{id}")
  public ResponseEntity<?> appendTemplate(@PathVariable Long id) {
    Template template = repository.findById(id).orElseThrow(() -> new TemplateNotFoundException(id));
    User user = template.getUser();
    List<Task> templateTaskList = template.getTasks();

    templateTaskList.forEach(task -> {
      addTaskToUser(user, task);
    });

    return ResponseEntity.ok(new JSONObject(Map.of("message", "Append template success")));
  }

  private void addTaskToUser(User user, Task task) {
    Task copiedTask = new Task(task);
    copiedTask.setUser(user);
    List<Task> userTaskList = user.getTasks();
    userTaskList.add(copiedTask);
    taskRepository.save(copiedTask);
  }
}
