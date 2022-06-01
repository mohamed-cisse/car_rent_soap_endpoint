package com.soap.producer.service;

import com.soap.producer.domain.CarElasticSearch;
import com.soap.producer.repository.ElasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElasticService {
    ElasRepository elasRepository;

    @Autowired
    public ElasticService(ElasRepository elasRepository) {
        this.elasRepository = elasRepository;
    }

    public CarElasticSearch save(CarElasticSearch car)
    {

        return  (CarElasticSearch) elasRepository.save(car);
    }
}
