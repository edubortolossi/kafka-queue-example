package com.example.kafkaexample.gateways.outputs.mongodb;

import com.example.kafkaexample.domains.KafkaExample;
import com.example.kafkaexample.gateways.KafkaExampleDataGateway;
import com.example.kafkaexample.gateways.outputs.mongodb.documents.KafkaExampleDocument;
import com.example.kafkaexample.gateways.outputs.mongodb.repositories.KafkaExampleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaExampleDataGatewayMongoImpl implements KafkaExampleDataGateway {

  private final KafkaExampleRepository kafkaExampleRepository;

  public void save(final KafkaExample kafkaExample) {
    kafkaExampleRepository.save(new KafkaExampleDocument(kafkaExample));
  }

}
