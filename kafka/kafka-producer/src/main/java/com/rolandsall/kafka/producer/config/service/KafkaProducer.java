package com.rolandsall.kafka.producer.config.service;

import org.apache.avro.specific.SpecificRecordBase;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

public interface KafkaProducer<K extends Serializable, V extends SpecificRecordBase> {
    void send(String topicName, K key, V message);
}
