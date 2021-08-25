package com.nathan.pet.PomofocusClone.api.repositories;

import com.nathan.pet.PomofocusClone.api.models.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "templates", path = "templates")
public interface TemplateRepository extends JpaRepository<Template, Long> {
}
