package com.lock.webapp.lockwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LockWebappApplication {

    public static void main(String[] args) {
        SpringApplication.run(LockWebappApplication.class, args);
    }

}
