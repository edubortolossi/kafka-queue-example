package com.example.kafkaexample.gateways.inputs.kafka;


import com.example.kafkaexample.configurations.kafka.TopicProperties;
import com.example.kafkaexample.gateways.inputs.kafka.resources.KafkaExampleResource;
import com.example.kafkaexample.usecases.SaveMessage;
import com.example.kafkaexample.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.naming.factory.BeanFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaExampleListener {

  private final TopicProperties topicProperties;
  private final JsonUtils jsonUtils;
  private final SaveMessage saveMessage;

  @KafkaListener(
      topics = "${spring.kafka.topics.kafkaExampleBroadcast}",
      containerFactory = "kafkaListenerContainerFactory")
  public void listener(
      @Payload final String message,
      @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) final String key,
      @Header(KafkaHeaders.RECEIVED_PARTITION_ID) final String partitionId,
      @Header(KafkaHeaders.OFFSET) final String offset) {
    log.debug(
        "Message received from topic {} partitionId {} offset {} key {} message {}",
        topicProperties.getKafkaExampleBroadcast(),
        partitionId,
        offset,
        key,
        message);
    try {
      final var resource = jsonUtils.toObject(message, KafkaExampleResource.class);
      saveMessage.execute(resource.toDomain());
    } catch (final Exception ex) {
      log.error(
          "Kafka Listener {} has failed for message {}.",
          topicProperties.getKafkaExampleBroadcast(),
          message,
          ex);
    }
  }
}
