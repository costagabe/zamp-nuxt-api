package com.br.zamp;

import com.br.zamp.misc.Initializer;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class ZampApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ZampApplication.class, args);
    }

    private final Initializer initializer;

    @Override
    public void run(String... args) {
        initializer.init();
    }


}
