package com.aios.technicaltest.payload;

import com.aios.technicaltest.model.Recipient;
import java.util.List;
import java.util.stream.Collectors;

public class RecipientPayload {
    
    private Long id;
    private String name;
    private String address;
    private Long zipCode;
    private String city;
    private String country;
    private List<OrderRequestPayload> orders;
    
    public RecipientPayload(Long id, String name, String address, Long zipCode, String city, String country, List<OrderRequestPayload> orders) {
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
        this.orders = orders;
    }
    
    public RecipientPayload(Recipient recipient) {
        this.name = recipient.getName();
        this.address = recipient.getAdress();
        this.zipCode = recipient.getZipCode();
        this.city = recipient.getCity();
        this.country = recipient.getCountry();
        this.orders = recipient.getOrders()
                .stream()
                .map(o -> new OrderRequestPayload(o))
                .collect(Collectors.toList());
    }
    
    public RecipientPayload() {
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<OrderRequestPayload> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderRequestPayload> orders) {
        this.orders = orders;
    }
}
