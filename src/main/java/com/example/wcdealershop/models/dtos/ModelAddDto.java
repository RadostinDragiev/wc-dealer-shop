package com.example.wcdealershop.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ModelAddDto {
    private String name;
    private String imageUrl;
    private int startYear;
    private int endYear;
    private BrandAddDto brand;
}
