package com.example.kafkaexample.gateways.outputs.kafka;

import com.example.kafkaexample.configurations.kafka.TopicProperties;
import com.example.kafkaexample.domains.KafkaExample;
import com.example.kafkaexample.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.SuccessCallback;

@Slf4j
@Component
@RequiredArgsConstructor
public class BroadcastKafkaProducer {

  private final KafkaTemplate<String, String> kafkaTemplate;
  private final TopicProperties topicProperties;
  private final JsonUtils jsonUtils;

  public void send(final KafkaExample kafkaExample) {
    final var message = jsonUtils.toJson(kafkaExample);
    final var topic = topicProperties.getKafkaExampleBroadcast();
    final var partitionKey = "kafkaExample";

    kafkaTemplate
        .send(topic, partitionKey, message)
        .addCallback(successCallback(message, partitionKey),
            failureCallback("KafkaExample", message, partitionKey));
  }

  private SuccessCallback<SendResult<String, String>> successCallback(
      final String message, final String key) {
    return result ->
        log.debug(
            "Message sent to topic: {} , key: {}, message: {}",
            topicProperties.getKafkaExampleBroadcast(),
            key,
            message);
  }

  private FailureCallback failureCallback(final String type,
                                          final String message, final String key) {
    return ex -> {
      log.error(
          "Error sent to topic: {} , key: {}, message: {}",
          topicProperties.getKafkaExampleBroadcast(),
          key,
          message);
    };
  }

}
