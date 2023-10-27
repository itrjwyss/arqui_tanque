package com.example.demo.repositories;

import com.example.demo.models.GasolineTankEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GasolineTankRepository extends JpaRepository<GasolineTankEntity, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE GasolineTankEntity gt SET gt.currentLevel = :currentLevel WHERE gt.id = :id")
    void updateCurrentLevel(@Param("id") Long id, @Param("currentLevel") double currentLevel);
}
