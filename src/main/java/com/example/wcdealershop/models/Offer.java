package com.example.wcdealershop.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Offer extends BaseEntity {
    private String description;
    @Enumerated(EnumType.ORDINAL)
    private Engine engine;
    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    @Enumerated(EnumType.ORDINAL)
    private Transmission transmission;
    private int year;
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime created;
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime modified;
    @ManyToOne
    private Model model;
    @OneToOne
    private User seller;
}
