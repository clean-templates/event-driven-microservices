package com.rolandsall.twitter.to.kafka.service.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ElasticQueryServiceApiResponse {
    private String id;
    private Long userId;
    private String text;
    private LocalDateTime createdAt;
}
