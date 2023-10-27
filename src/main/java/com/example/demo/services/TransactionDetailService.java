package com.example.demo.services;

import com.example.demo.models.TransactionDetailEntity;
import com.example.demo.repositories.TransactionDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionDetailService {

    @Autowired
    private TransactionDetailRepository transactionDetailRepository;

    public void saveTransactionDetail(TransactionDetailEntity transactionDetailEntity) {
        transactionDetailRepository.save(transactionDetailEntity);
    }
}
