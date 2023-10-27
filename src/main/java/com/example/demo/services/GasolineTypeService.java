package com.example.demo.services;

import com.example.demo.repositories.GasolineTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GasolineTypeService {

    @Autowired
    private GasolineTypeRepository gasolineTypeRepository;
}
