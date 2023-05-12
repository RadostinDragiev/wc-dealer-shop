package com.example.wcdealershop.service.impl;

import com.example.wcdealershop.models.Brand;
import com.example.wcdealershop.models.dtos.BrandAddDto;
import com.example.wcdealershop.repository.BrandRepository;
import com.example.wcdealershop.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addBrand(BrandAddDto brandAddDto) {
        Brand brand = this.modelMapper.map(brandAddDto, Brand.class);
        LocalDateTime now = LocalDateTime.now();
        brand.setCreated(now);
        brand.setModified(now);
        this.brandRepository.saveAndFlush(brand);
    }
}
