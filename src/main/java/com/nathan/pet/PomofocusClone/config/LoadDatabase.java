package com.nathan.pet.PomofocusClone.config;

import com.nathan.pet.PomofocusClone.api.models.User;
import com.nathan.pet.PomofocusClone.api.repositories.UserRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Configuration
public class LoadDatabase {
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(UserRepository repository) {
    TimeZone tz = TimeZone.getTimeZone("UTC");
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
    df.setTimeZone(tz);
    String nowAsISO = df.format(new Date());

    return args -> {
      log.info("Preloading" + repository.save(
          new User(nowAsISO, nowAsISO, "Nathan", "123@gmail.com", "qwerty")));
      log.info("Preloading" + repository.save(
          new User(nowAsISO, nowAsISO, "Peter", "456@gmail.com", "123456")));
      log.info("Preloading" + repository.save(
          new User(nowAsISO, nowAsISO, "Mike", "678@gmail.com", "1234789")));
    };
  }
}
