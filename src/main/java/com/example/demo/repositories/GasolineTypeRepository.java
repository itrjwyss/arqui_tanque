package com.example.demo.repositories;

import com.example.demo.models.GasolineTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GasolineTypeRepository extends JpaRepository<GasolineTypeEntity, Long> {
}
