package com.example.demo.request;

public class TransactionRequest {

    private Long gasolineTankId;
    private double amount;
    private String clientName;
    private String paymentType;

    public Long getGasolineTankId() {
        return gasolineTankId;
    }

    public void setGasolineTankId(Long gasolineTankId) {
        this.gasolineTankId = gasolineTankId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

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
}
