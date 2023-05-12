package com.example.wcdealershop.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRole extends BaseEntity {
    @Enumerated(EnumType.ORDINAL)
    private Role role;
}
