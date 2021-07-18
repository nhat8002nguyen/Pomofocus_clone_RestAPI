package com.nathan.pet.PomofocusClone.api.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.util.Objects;


@Entity
public class User {
  private @Id @GeneratedValue Long id;
  private String name;
  private String gmail;
  private String password;
  private String createdAt;
  private String updatedAt;

  public User() {}

  public User(String createdAt, String updatedAt, String name, String gmail, String password) {
    this.createdAt= createdAt;
    this.updatedAt = updatedAt;
    this.name = name;
    this.gmail = gmail;
    this.password = password;
    this.createdAt = createdAt;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setGmail(String gmail) {
    this.gmail = gmail;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getGmail() {
    return gmail;
  }

  public String getPassword() {
    return password;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return id.equals(user.id) && name.equals(user.name) && gmail.equals(user.gmail) && password.equals(user.password) && createdAt.equals(user.createdAt) && Objects.equals(updatedAt, user.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, gmail, password, createdAt, updatedAt);
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", gmail='" + gmail + '\'' +
        ", password='" + password + '\'' +
        ", createdAt='" + createdAt + '\'' +
        ", updatedAt='" + updatedAt + '\'' +
        '}';
  }
}
