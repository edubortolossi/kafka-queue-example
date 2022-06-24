package com.example.kafkaexample.gateways.inputs.http.external.resources.request;

import com.example.kafkaexample.domains.KafkaExample;
import lombok.Data;

@Data
public class KafkaMessageRequest {

  private String firstName;
  private String lastName;
  private int age;
  private String zipCode;

  public KafkaExample toDomain() {
    return KafkaExample.builder()
        .firstName(firstName).lastName(lastName)
        .age(age).zipCode(zipCode).build();
  }

}
