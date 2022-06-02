package com.soap.producer.elasticsearch.service;

import com.soap.producer.elasticsearch.domain.CarElasticSearch;
import com.soap.producer.elasticsearch.repository.ElasRepository;
import com.soap.producer.elasticsearch.searchrequest.ElasticDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElasticService {


    ElasRepository elasRepository;

    @Autowired
    public ElasticService(ElasRepository elasRepository) {
        this.elasRepository = elasRepository;
    }


    public List<String> autocomplete(ElasticDTO dto) {

        return modelList(elasRepository.findByModelContaining(dto.getSearchTerm()));
    }

    public List<String> modelList(List<CarElasticSearch> cars) {
        List<String> models = new ArrayList<String>();
        for (CarElasticSearch car : cars) {
            models.add(car.getModel());
        }

        return models;
    }

}
