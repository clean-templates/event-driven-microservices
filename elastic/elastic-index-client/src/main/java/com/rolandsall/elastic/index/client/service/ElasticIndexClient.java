package com.rolandsall.elastic.index.client.service;


import com.rolandsall.elastic.model.index.IndexModel;

import java.util.List;

public interface ElasticIndexClient<T extends IndexModel> {
    List<String> save(List<T> documents);
}
