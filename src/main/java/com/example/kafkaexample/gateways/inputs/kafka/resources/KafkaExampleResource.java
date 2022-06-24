package com.example.kafkaexample.gateways.inputs.kafka.resources;

import com.example.kafkaexample.domains.KafkaExample;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KafkaExampleResource {
  private String firstName;
  private String lastName;
  private int age;
  private String zipCode;

  public KafkaExample toDomain() {
    return KafkaExample.builder()
        .firstName(firstName)
        .lastName(lastName)
        .zipCode(zipCode)
        .age(age).build();
  }
}
