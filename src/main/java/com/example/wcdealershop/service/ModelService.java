package com.example.wcdealershop.service;

import com.example.wcdealershop.models.Model;
import com.example.wcdealershop.models.dtos.ModelAddDto;

public interface ModelService {
    void addModel(ModelAddDto modelAddDto);

    Model getModelByNameAndYear(String name, int year);
}
