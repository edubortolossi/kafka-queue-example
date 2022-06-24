package com.example.kafkaexample.usecases;

import com.example.kafkaexample.domains.KafkaExample;
import com.example.kafkaexample.gateways.outputs.kafka.BroadcastKafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PublishMessage {

  private final BroadcastKafkaProducer broadcastKafkaProducer;

  public void execute( final KafkaExample message) {
    broadcastKafkaProducer.send(message);
  }
}
