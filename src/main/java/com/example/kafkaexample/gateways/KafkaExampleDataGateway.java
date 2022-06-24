package com.example.kafkaexample.gateways;

import com.example.kafkaexample.domains.KafkaExample;

public interface KafkaExampleDataGateway {

  void save(final KafkaExample kafkaExample);
}
