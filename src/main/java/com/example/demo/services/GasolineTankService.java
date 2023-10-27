package com.example.demo.services;

import com.example.demo.models.GasolineTankEntity;
import com.example.demo.repositories.GasolineTankRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GasolineTankService {

    @Autowired
    private GasolineTankRepository gasolineTankRepository;

    public Optional<GasolineTankEntity> findById(Long id) {
        return gasolineTankRepository.findById(id);
    }

    public void updateCurrentLevel(Long id, double currentLevel) {
        gasolineTankRepository.updateCurrentLevel(id, currentLevel);
    }
}
