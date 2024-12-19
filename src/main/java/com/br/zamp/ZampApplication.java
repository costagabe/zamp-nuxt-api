package com.br.zamp;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaRepositories(basePackages = "com.br.zamp.repository")
@AllArgsConstructor
public class ZampApplication {
  public static void main(String[] args) {
    SpringApplication.run(ZampApplication.class, args);
  }
}
