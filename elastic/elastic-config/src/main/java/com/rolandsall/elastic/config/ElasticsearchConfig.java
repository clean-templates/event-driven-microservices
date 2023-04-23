package com.rolandsall.elastic.config;

import com.rolandsall.app.config.data.config.ElasticConfigData;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.Objects;

@Configuration
@RequiredArgsConstructor
@EnableElasticsearchRepositories(basePackages = "com.rolandsall.elastic")
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {

    private final ElasticConfigData elasticConfigData;


    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        UriComponents serverUri = UriComponentsBuilder.fromHttpUrl(elasticConfigData.getConnectionUrl()).build();
        HttpHost elasticHttpHost = new HttpHost(
                Objects.requireNonNull(serverUri.getHost()),
                serverUri.getPort(),
                serverUri.getScheme()
        );
        return new RestHighLevelClient(RestClient.builder(elasticHttpHost)
                .setRequestConfigCallback(
                        requestConfigBuilder ->
                                requestConfigBuilder
                                        .setConnectTimeout(elasticConfigData.getConnectTimeoutMs())
                                        .setSocketTimeout(elasticConfigData.getSocketTimeoutMs())

                )
        );
    }

    @Bean
    public ElasticsearchOperations elasticSearch() {
        return new ElasticsearchRestTemplate(elasticsearchClient());
    }
}
