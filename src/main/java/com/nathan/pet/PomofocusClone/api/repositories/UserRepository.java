package com.nathan.pet.PomofocusClone.api.repositories;

import com.nathan.pet.PomofocusClone.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
