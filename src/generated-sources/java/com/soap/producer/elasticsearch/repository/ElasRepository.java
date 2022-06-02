package com.soap.producer.elasticsearch.repository;

import com.soap.producer.elasticsearch.domain.CarElasticSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ElasRepository extends ElasticsearchRepository<CarElasticSearch,Integer>  {
    List<CarElasticSearch> findByModelContaining(String model);
}
