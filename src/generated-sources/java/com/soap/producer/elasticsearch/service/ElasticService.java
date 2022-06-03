package com.soap.producer.elasticsearch.service;

import com.soap.producer.elasticsearch.domain.CarElasticSearch;
import com.soap.producer.elasticsearch.repository.ElasRepository;
import com.soap.producer.elasticsearch.searchrequest.ElasticDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ElasticService {


    ElasRepository elasRepository;

    @Autowired
    public ElasticService(ElasRepository elasRepository) {
        this.elasRepository = elasRepository;
    }


    public List<String> autocomplete(ElasticDTO dto) {

        return elasRepository.findByModelContaining(dto.getSearchTerm())
                .stream()
                .map(car -> car.getModel())
                .collect(Collectors.toList());
    }

}
