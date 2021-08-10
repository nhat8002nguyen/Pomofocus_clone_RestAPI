package com.nathan.pet.PomofocusClone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan({"com.nathan.pet.PomofocusClone"})
@EntityScan("com.nathan.pet.PomofocusClone.api.models")
@EnableJpaRepositories("com.nathan.pet.PomofocusClone.api.repositories")
public class PomofocusCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(PomofocusCloneApplication.class, args);
	}
}
