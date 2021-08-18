package com.nathan.pet.PomofocusClone.api.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "template")
public class Template {
  @Id @GeneratedValue
  private Long id;

  @CreationTimestamp
  @Column(updatable = false, nullable = false)
  private Date createAt;

  @UpdateTimestamp
  @Column(nullable = false)
  private Date updatedAt;

  @NotBlank
  @Size(min = 1, max = 1000)
  private String name;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @OneToMany(mappedBy = "template")
  private List<Task> tasks;

  public Template() {}

  public Template(Date createAt, Date updatedAt, String name) {
    this.createAt = createAt;
    this.updatedAt = updatedAt;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public Date getCreateAt() {
    return createAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public String getName() {
    return name;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Template)) return false;
    Template template = (Template) o;
    return id.equals(template.id) && createAt.equals(template.createAt) && Objects.equals(updatedAt, template.updatedAt) && name.equals(template.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createAt, updatedAt, name);
  }

  @Override
  public String toString() {
    return "Template{" +
        "id=" + id +
        ", createAt=" + createAt +
        ", updatedAt=" + updatedAt +
        ", name='" + name + '\'' +
        '}';
  }
}
