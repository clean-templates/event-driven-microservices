package com.rolandsall.elastic.index.client.util;

import com.rolandsall.elastic.model.index.IndexModel;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ElasticIndexUtil<T extends IndexModel> {

    /***
     * This utility class can be used to convert
     * a list of domain objects into a list of index queries that can be used to perform batch indexing
     * or updating in Elasticsearch.
     */
    public List<IndexQuery> getIndexQueries(List<T> documents) {
        return documents.stream()
                .map(document -> new IndexQueryBuilder()
                        .withId(document.getId())
                        .withObject(document)
                        .build()
                ).collect(Collectors.toList());
    }
}
