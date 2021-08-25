package com.nathan.pet.PomofocusClone.api.models;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "task")
public class Task {
  @Id @NotBlank
  private String id;

  @CreationTimestamp
  @Column(updatable = false, nullable = false)
  private Date createdAt;

  @UpdateTimestamp
  @Column(nullable = false)
  private Date updatedAt;

  @NotBlank
  @Size(max = 1000, min = 1)
  private String title = "";

  @Size(max = 1000)
  private String note;

  @NotNull
  @Min(value = 0)
  @Max(value = 100)
  private int donePomo = 0;

  @NotNull
  @Min(value = 0)
  @Max(value = 100)
  private int totalPomo;

  @NotNull
  private boolean done = false;

  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "template_id")
  private Template template;

  public Task() {
  }

  public Task(Date createdAt, Date updatedAt, String title, String note, int donePomo, int totalPomo, boolean done) {
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.title = title;
    this.note = note;
    this.donePomo = donePomo;
    this.totalPomo = totalPomo;
    this.done = done;
  }

  public Task(Task task) {
    this.id = UUID.randomUUID().toString();
    this.title = task.getTitle();
    this.note = task.getNote();
    this.donePomo = 0;
    this.totalPomo = task.getTotalPomo();
    this.done = false;
  }

  public void setId(String id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public Template getTemplate() {
    return template;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setTemplate(Template template) {
    this.template = template;
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

  public String getId() {
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
    return donePomo == task.donePomo && totalPomo == task.totalPomo && done == task.done && id.equals(task.id)
        && createdAt.equals(task.createdAt) && Objects.equals(updatedAt, task.updatedAt) && title.equals(task.title)
        && Objects.equals(note, task.note);
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
