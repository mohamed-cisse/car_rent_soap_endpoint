package com.soap.producer.elasticsearch.searchrequest;

import java.util.List;

public class ElasticDTO {


    private String searchTerm;
    private String model;


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }


}
