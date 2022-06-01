package com.soap.producer.repository;

import com.soap.producer.domain.Car;
import com.soap.producer.domain.CarElasticSearch;
import org.springframework.context.annotation.Primary;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ElasRepository extends ElasticsearchRepository<CarElasticSearch,Integer>  {

}
