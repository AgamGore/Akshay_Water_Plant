package com.wplnt.akshay.waterPlant.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    public Customer() {
    }

    private String name;
    private String address;
    private String mobileNumber;
    private String paymentType;
    private Integer bootleType;

    public Customer(String name, String address, String mobileNumber, String paymentType, Integer bootleType) {
        this.name = name;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.paymentType = paymentType;
        this.bootleType = bootleType;
    }
}
