package com.rolandsall.elastic.query.service.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class ElasticDocumentController implements IElasticDocumentApi {
    @Override
    public ResponseEntity<List<ElasticQueryServiceApiResponse>> getAllDocuments() {
        List<ElasticQueryServiceApiResponse> response = new ArrayList<>();
        log.info("Elasticsearch returned {} of documents", response.size());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ElasticQueryServiceApiResponse> getDocumentById(String id) {
        ElasticQueryServiceApiResponse elasticQueryServiceResponseModel = buildElasticQueryServiceResponseModel(id);
        log.debug("Elasticsearch returned document with id {}", id);
        return ResponseEntity.ok(elasticQueryServiceResponseModel);
    }


    @Override
    public ResponseEntity<List<ElasticQueryServiceApiResponse>> getDocumentByText(ElasticQueryServiceApiRequest elasticQueryServiceRequestModel) {
        List<ElasticQueryServiceApiResponse> response = new ArrayList<>();
        ElasticQueryServiceApiResponse elasticQueryServiceResponseModel = getElasticQueryServiceResponseModel(elasticQueryServiceRequestModel);
        response.add(elasticQueryServiceResponseModel);
        log.info("Elasticsearch returned {} of documents", response.size());
        return ResponseEntity.ok(response);
    }

    private static ElasticQueryServiceApiResponse getElasticQueryServiceResponseModel(ElasticQueryServiceApiRequest elasticQueryServiceRequestModel) {
        return ElasticQueryServiceApiResponse.builder()
                .text(elasticQueryServiceRequestModel.getText())
                .build();
    }


    private static ElasticQueryServiceApiResponse buildElasticQueryServiceResponseModel(String id) {
        return ElasticQueryServiceApiResponse.builder()
                .id(id)
                .build();
    }
}
