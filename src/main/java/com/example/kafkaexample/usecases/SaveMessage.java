package com.example.kafkaexample.usecases;

import com.example.kafkaexample.domains.KafkaExample;
import com.example.kafkaexample.gateways.KafkaExampleDataGateway;
import com.example.kafkaexample.gateways.inputs.kafka.resources.KafkaExampleResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveMessage {

  private final KafkaExampleDataGateway kafkaExampleDataGateway;

  public void execute(final KafkaExample message) {
    kafkaExampleDataGateway.save(message);
  }
}
