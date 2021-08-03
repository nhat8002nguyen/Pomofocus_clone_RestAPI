package com.nathan.pet.PomofocusClone.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nathan.pet.PomofocusClone.api.models.Setting;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "settings", path = "settings")
public interface SettingRepository extends JpaRepository<Setting, Long> {
}
