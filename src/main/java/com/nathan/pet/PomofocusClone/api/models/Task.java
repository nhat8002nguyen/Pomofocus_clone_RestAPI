package com.nathan.pet.PomofocusClone.api.models;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "task")
public class Task {
  @Id @GeneratedValue
  private Long id;

  @CreationTimestamp
  @Column(updatable = false, nullable = false)
  private Date createdAt;

  @UpdateTimestamp
  @Column(nullable = false)
  private Date updatedAt;

  @NotBlank
  @Size(max = 1000, min = 1)
  private String title;

  @Size(max = 1000)
  private String note;

  @NotNull
  @Min(value = 0)
  @Max(value = 100)
  private int donePomo;

  @NotNull
  @Min(value = 0)
  @Max(value = 100)
  private int totalPomo;

  @NotNull
  private boolean done;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "template_id")
  private Template template;

  public Task() {}

  public Task(Date createdAt, Date updatedAt, String title, String note, int donePomo, int totalPomo, boolean done) {
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.title = title;
    this.note = note;
    this.donePomo = donePomo;
    this.totalPomo = totalPomo;
    this.done = done;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public void setDonePomo(int donePomo) {
    this.donePomo = donePomo;
  }

  public void setTotalPomo(int totalPomo) {
    this.totalPomo = totalPomo;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

  public Long getId() {
    return id;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public String getTitle() {
    return title;
  }

  public String getNote() {
    return note;
  }

  public int getDonePomo() {
    return donePomo;
  }

  public int getTotalPomo() {
    return totalPomo;
  }

  public boolean isDone() {
    return done;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Task)) return false;
    Task task = (Task) o;
    return donePomo == task.donePomo && totalPomo == task.totalPomo && done == task.done && id.equals(task.id) && createdAt.equals(task.createdAt) && Objects.equals(updatedAt, task.updatedAt) && title.equals(task.title) && Objects.equals(note, task.note);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdAt, updatedAt, title, note, donePomo, totalPomo, done);
  }

  @Override
  public String toString() {
    return "Task{" +
        "id=" + id +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        ", title='" + title + '\'' +
        ", note='" + note + '\'' +
        ", donePomo=" + donePomo +
        ", totalPomo=" + totalPomo +
        ", done=" + done +
        '}';
  }
}
