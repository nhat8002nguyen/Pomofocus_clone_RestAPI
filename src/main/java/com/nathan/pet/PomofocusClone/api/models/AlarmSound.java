package com.nathan.pet.PomofocusClone.api.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.util.Objects;

@Entity
public class AlarmSound {
  private @Id @GeneratedValue Long id;
  private String createdAt;
  private String updatedAt;
  private String name;

  public AlarmSound() {}

  public AlarmSound(String createdAt, String updatedAt, String name) {
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public String getName() {
    return name;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AlarmSound that = (AlarmSound) o;
    return id.equals(that.id) && createdAt.equals(that.createdAt) && Objects.equals(updatedAt, that.updatedAt) && name.equals(that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdAt, updatedAt, name);
  }

  @Override
  public String toString() {
    return "AlarmSound{" +
        "id=" + id +
        ", createdAt='" + createdAt + '\'' +
        ", updatedAt='" + updatedAt + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
