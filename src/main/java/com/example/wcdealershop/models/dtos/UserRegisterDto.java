package com.example.wcdealershop.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDto {
    private String username;
    private String firstName;
    private String lastName;
    private String imageUrl;
}
