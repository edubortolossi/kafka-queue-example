package com.example.kafkaexample.gateways.outputs.mongodb.documents;

import com.example.kafkaexample.domains.KafkaExample;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("kafkaExample")
public class KafkaExampleDocument {
  @Id
  private String id;
  private String firstName;
  private String lastName;
  private int age;
  private String zipCode;

  public KafkaExampleDocument(final KafkaExample kafkaExample) {
    this.firstName = kafkaExample.getFirstName();
    this.lastName = kafkaExample.getLastName();
    this.age = kafkaExample.getAge();
    this.zipCode = kafkaExample.getZipCode();
  }
}
