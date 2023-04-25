package com.rolandsall.twitter.to.kafka.service.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ElasticQueryServiceApiRequest {
    private String id;
    private String text;
}
