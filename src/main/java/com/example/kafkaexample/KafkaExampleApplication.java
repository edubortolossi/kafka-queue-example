package com.example.kafkaexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class KafkaExampleApplication {

  public static void main(final String[] args) {
    SpringApplication.run(KafkaExampleApplication.class, args);
  }
}