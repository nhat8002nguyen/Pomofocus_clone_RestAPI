package com.nathan.pet.PomofocusClone.api.repositories;

import com.nathan.pet.PomofocusClone.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository<User, Long> {
  @Query(value = "SELECT * FROM user u WHERE u.name = :username limit 1", nativeQuery = true)
  User findByUsername(@Param("username") String username);

  @Query(value = "select * from user u where u.gmail = :gmail limit 1", nativeQuery = true)
  User findByGmail(@Param("gmail") String gmail);
}
