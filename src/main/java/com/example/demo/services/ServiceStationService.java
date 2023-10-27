package com.example.demo.services;

import com.example.demo.repositories.ServiceStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceStationService {

    @Autowired
    private ServiceStationRepository serviceStationRepository;
}
