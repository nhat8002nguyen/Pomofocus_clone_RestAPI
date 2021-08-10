package com.nathan.pet.PomofocusClone.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nathan.pet.PomofocusClone.api.models.Setting;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@RepositoryRestResource(collectionResourceRel = "settings", path = "settings")
@CrossOrigin(origins = "*")
public interface SettingRepository extends JpaRepository<Setting, Long> {
}
