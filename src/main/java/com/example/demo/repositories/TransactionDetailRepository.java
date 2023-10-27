package com.example.demo.repositories;

import com.example.demo.models.TransactionDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailRepository extends JpaRepository<TransactionDetailEntity, Integer> {
}
