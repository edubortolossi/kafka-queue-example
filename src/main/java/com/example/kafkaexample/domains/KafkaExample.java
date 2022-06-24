package com.example.kafkaexample.domains;

import com.example.kafkaexample.gateways.inputs.kafka.resources.KafkaExampleResource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KafkaExample {
  private String firstName;
  private String lastName;
  private int age;
  private String zipCode;
}
