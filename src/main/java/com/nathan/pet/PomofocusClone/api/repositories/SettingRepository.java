package com.nathan.pet.PomofocusClone.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nathan.pet.PomofocusClone.api.models.Setting;

public interface SettingRepository extends JpaRepository<Setting, Long> {
}
