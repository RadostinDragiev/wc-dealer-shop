package com.example.wcdealershop.service.impl;

import com.example.wcdealershop.models.Offer;
import com.example.wcdealershop.models.dtos.OfferAddDto;
import com.example.wcdealershop.repository.OfferRepository;
import com.example.wcdealershop.service.ModelService;
import com.example.wcdealershop.service.OfferService;
import com.example.wcdealershop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final ModelService modelService;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, UserService userService, ModelService modelService) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.modelService = modelService;
    }

    @Override
    @Transactional
    public void createOffer(OfferAddDto offerAddDto) {
        Offer offer = this.modelMapper.map(offerAddDto, Offer.class);
        LocalDateTime now = LocalDateTime.now();
        offer.setCreated(now);
        offer.setModified(now);
        offer.setSeller(this.userService.getUserByUsername(offerAddDto.getUsername()));
        offer.setModel(this.modelService.getModelByNameAndYear(offerAddDto.getModel(), offerAddDto.getYear()));
        this.offerRepository.saveAndFlush(offer);
    }

    @Override
    public List<Offer> getAllOffers() {
        return this.offerRepository.findAll();
    }

    @Override
    public Offer getByOfferId(String id) {
        return this.offerRepository.findById(id).orElse(new Offer());
    }
}
