package com.nathan.pet.PomofocusClone.api.controllers;

import com.nathan.pet.PomofocusClone.api.models.Task;
import com.nathan.pet.PomofocusClone.api.models.User;
import com.nathan.pet.PomofocusClone.api.repositories.TaskRepository;
import com.nathan.pet.PomofocusClone.api.repositories.UserRepository;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class TaskController {
  private TaskRepository repository;
  private UserRepository userRepository;

  public TaskController(TaskRepository repository, UserRepository userRepository) {
    this.repository = repository;
    this.userRepository = userRepository;
  }

  @PostMapping("/user/tasks")
  public ResponseEntity<?> addTask(@RequestParam String name, @Valid @RequestBody Task task) {
    User user = userRepository.findByUsername(name);
    if (user == null) return ResponseEntity.badRequest()
        .body( new JSONObject(Map.of("message", "User not found")));

    List<Task> taskList = user.getTasks();
    taskList.add( task);
    task.setUser(user);

    repository.save(task);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
