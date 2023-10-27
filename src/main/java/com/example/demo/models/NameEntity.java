package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class NameEntity extends BaseEntity {

    @Column(length = 75, nullable = false, unique = true)
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
