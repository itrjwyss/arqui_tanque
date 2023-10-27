package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "gasoline_tank")
public class GasolineTankEntity extends BaseEntity {

    @Column(nullable = false)
    private Double capacity;

    @Column(name = "current_level", nullable = false)
    private Double currentLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gasoline_type_id", nullable = false)
    private GasolineTypeEntity gasolineTypeEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_station_id", nullable = false)
    private ServiceStationEntity serviceStation;

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Double getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Double currentLevel) {
        this.currentLevel = currentLevel;
    }

    public GasolineTypeEntity getGasolineType() {
        return gasolineTypeEntity;
    }

    public void setGasolineType(GasolineTypeEntity gasolineTypeEntity) {
        this.gasolineTypeEntity = gasolineTypeEntity;
    }

    public ServiceStationEntity getServiceStation() {
        return serviceStation;
    }

    public void setServiceStation(ServiceStationEntity serviceStation) {
        this.serviceStation = serviceStation;
    }
}
