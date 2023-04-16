package com.rolandsall.twitter.to.kafka.service.external.init;

import com.rolandsall.app.config.data.config.KafkaConfigData;
import com.rolandsall.kafka.admin.client.KafkaAdminClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaStreamInitializer implements StreamInitializer {

    private final KafkaConfigData kafkaConfigData;
    private final KafkaAdminClient kafkaAdminClient;

    @Override
    public void init() {
        kafkaAdminClient.createTopics();
        kafkaAdminClient.checkSchemaRegistry();
        log.info("Topic with name {} is ready for operations!", kafkaConfigData.getTopicNamesToCreate().toArray());
    }
}
