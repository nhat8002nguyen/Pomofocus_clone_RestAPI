package com.nathan.pet.PomofocusClone.api.repositories;

import com.nathan.pet.PomofocusClone.api.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RepositoryRestResource(collectionResourceRel = "tasks", path = "tasks")
public interface TaskRepository extends JpaRepository<Task, String> {

  @Modifying
  @Transactional
  @Query(nativeQuery = true,
      value = "insert into task (id, title, note, total_pomo, done_pomo, done, created_at, updated_at, user_id)" +
          " values (:id, :title, :note, :total_pomo, :done_pomo, :done, :created_at, :updated_at, :user_id)")
  void insertTask(@Param("id") String id, @Param("title") String title, @Param("note") String note, @Param("total_pomo") int totalPomo,
                  @Param("done_pomo") int donePomo, @Param("done") boolean done, @Param("created_at") Date created_at,
                  @Param("updated_at") Date updatedAt, @Param("user_id") Long userId);
}
