package com.nathan.pet.PomofocusClone.api.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name="user")
public class User {
  private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;

  @NotBlank(message = "name is mandatory")
  @Size(min = 4, max = 255)
  private String name;

  @NotBlank(message = "email is mandatory")
  @Size(min = 4, max = 255)
  private String gmail;

  @Size(min = 4, max = 255)
  @NotBlank(message = "password is mandatory")
  private String password;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "setting_id")
  @RestResource(path="userSetting", rel="setting")
  private Setting setting;

  @OneToMany(mappedBy = "user")
  private List<Task> tasks;

  @OneToMany(mappedBy = "user")
  private List<Template> templates;

  @CreationTimestamp
  @Column(updatable = false, nullable = false)
  private Date createdAt;

  @UpdateTimestamp
  @Column(nullable = false)
  private Date updatedAt;

  public void setSetting(Setting setting) {
    this.setting = setting;
  }

  public Setting getSetting() {
    return setting;
  }

  public User() {}

  public User(Date createdAt, Date updatedAt, String name, String gmail, String password) {
    this.createdAt= createdAt;
    this.updatedAt = updatedAt;
    this.name = name;
    this.gmail = gmail;
    this.password = password;
    this.createdAt = createdAt;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  public void setTemplates(List<Template> templates) {
    this.templates = templates;
  }

  public List<Task> getTasks() {
    return tasks;
  }

  public List<Template> getTemplates() {
    return templates;
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

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
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

  public Date getCreatedAt() {
    return createdAt;
  }

  public Date getUpdatedAt() {
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
