package com.br.zamp;

import com.br.zamp.misc.Initializer;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
@AllArgsConstructor
public class ZampApplication implements CommandLineRunner {

  private final Initializer initializer;

  public static void main(String[] args) {
    SpringApplication.run(ZampApplication.class, args);
  }

  @Override
  public void run(String... args) {
    initializer.init();
  }


}
