package com.example.wcdealershop.repository;

import com.example.wcdealershop.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, String> {
    Model getModelByNameAndStartYearBeforeAndEndYearIsAfter(String name, int startYear, int endYear);
}
