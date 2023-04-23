package com.rolandsall.kafka.to.elastic.service.transformer;

import com.kafka.avro.model.TwitterAvroModel;
import com.rolandsall.elastic.model.index.TwitterIndexModel;
import org.springframework.stereotype.Component;

import java.time.*;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AvroToElasticModelTransformer {

    public List<TwitterIndexModel> getElasticModels(List<TwitterAvroModel> avroModels) {
        return avroModels.stream()
                .map(avroModel -> TwitterIndexModel
                        .builder()
                        .userId(avroModel.getUserId())
                        .id(String.valueOf(avroModel.getId()))
                        .text(avroModel.getText())
                        .createdAt(Instant.ofEpochSecond(avroModel.getCreatedAt()).atZone(ZoneId.systemDefault()))
                        .build()
                ).collect(Collectors.toList());
    }
}
