package com.nathan.pet.PomofocusClone.api.repositories;

import com.nathan.pet.PomofocusClone.api.models.AlarmSound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface AlarmSoundRepository extends JpaRepository<AlarmSound, Long> {
}
