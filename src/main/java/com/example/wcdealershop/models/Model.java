package com.example.wcdealershop.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "models")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Model extends BaseEntity {
    private String name;
    private String imageUrl;
    private int startYear;
    private int endYear;
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime created;
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime modified;
    @ManyToOne(cascade = CascadeType.ALL)
    private Brand brand;
}
