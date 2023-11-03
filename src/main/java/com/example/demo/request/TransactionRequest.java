package com.example.demo.request;

public class TransactionRequest {

    private Long gasolineTankId;
    private double gallons;
    private String customerName;
    private String paymentType;

    public Long getGasolineTankId() {
        return gasolineTankId;
    }

    public void setGasolineTankId(Long gasolineTankId) {
        this.gasolineTankId = gasolineTankId;
    }

    public double getGallons() {
        return gallons;
    }

    public void setGallons(double gallons) {
        this.gallons = gallons;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
