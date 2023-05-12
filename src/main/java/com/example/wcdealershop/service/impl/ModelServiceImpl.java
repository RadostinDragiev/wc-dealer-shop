package com.example.wcdealershop.service.impl;

import com.example.wcdealershop.models.Model;
import com.example.wcdealershop.models.dtos.ModelAddDto;
import com.example.wcdealershop.repository.ModelRepository;
import com.example.wcdealershop.service.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public void addModel(ModelAddDto modelAddDto) {
        Model model = this.modelMapper.map(modelAddDto, Model.class);
        LocalDateTime now = LocalDateTime.now();
        model.setCreated(now);
        model.setModified(now);

        this.modelRepository.saveAndFlush(model);
    }

    @Override
    public Model getModelByNameAndYear(String name, int year) {
        return this.modelRepository.getModelByNameAndStartYearBeforeAndEndYearIsAfter(name, year, year);
    }
}
