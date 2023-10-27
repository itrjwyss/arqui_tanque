package com.example.demo.repositories;

import com.example.demo.models.ServiceStationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceStationRepository extends JpaRepository<ServiceStationEntity, Long> {
}
