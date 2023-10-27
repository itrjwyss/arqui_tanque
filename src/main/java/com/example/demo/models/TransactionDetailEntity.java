package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "transaction_detail")
public class TransactionDetailEntity extends BaseEntity {

    @Column(name = "client_name", length = 100)
    private String clientName;

    @Column(name = "payment_type", length = 20)
    private String paymentType;

    @Temporal(TemporalType.DATE)
    @Column(name = "transaction_date")
    private Date transactionDate;

    @Temporal(TemporalType.TIME)
    @Column(name = "transaction_hour")
    private Date transactionHour;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Date getTransactionHour() {
        return transactionHour;
    }

    public void setTransactionHour(Date transactionHour) {
        this.transactionHour = transactionHour;
    }
}
