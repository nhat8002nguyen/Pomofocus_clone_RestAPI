package com.nathan.pet.PomofocusClone.api.repositories;

import com.nathan.pet.PomofocusClone.api.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tasks", path = "tasks")
public interface TaskRepository extends JpaRepository<Task, Long> {
}
