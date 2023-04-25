package com.rolandsall.twitter.to.kafka.service.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/documents")
public interface IElasticDocumentApi {



    @GetMapping("/")
    ResponseEntity<List<ElasticQueryServiceApiResponse>> getAllDocuments();

    @GetMapping("/{id}")
    ResponseEntity<ElasticQueryServiceApiResponse> getDocumentById(@PathVariable String id);


    @PostMapping("/get-document-by-text")
    ResponseEntity<List<ElasticQueryServiceApiResponse>> getDocumentByText(@RequestBody ElasticQueryServiceApiRequest elasticQueryServiceRequestModel);
}
