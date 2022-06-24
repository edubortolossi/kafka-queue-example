package com.example.kafkaexample.gateways.outputs.mongodb.repositories;

import com.example.kafkaexample.gateways.outputs.mongodb.documents.KafkaExampleDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KafkaExampleRepository extends
    MongoRepository<KafkaExampleDocument, String> {
}
