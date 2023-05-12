package com.example.wcdealershop.models.dtos;

import com.example.wcdealershop.models.Engine;
import com.example.wcdealershop.models.Transmission;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OfferAddDto {
    private String model;
    private int year;
    private Engine engine;
    private BigDecimal mileage;
    private String category;
    private double price;
    private Transmission transmission;
    private String username;
    private String imageUrl;
    private String description;
}
