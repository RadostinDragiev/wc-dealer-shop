package com.example.wcdealershop.service;

import com.example.wcdealershop.models.Offer;
import com.example.wcdealershop.models.dtos.OfferAddDto;

import java.util.List;

public interface OfferService {
    void createOffer(OfferAddDto offerAddDto);

    List<Offer> getAllOffers();

    Offer getByOfferId(String id);
}
