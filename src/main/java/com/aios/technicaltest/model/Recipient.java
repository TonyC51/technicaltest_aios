package com.aios.technicaltest.model;

import com.aios.technicaltest.payload.RecipientPayload;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "recipient")
public class Recipient implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "name", nullable=false, unique=true)
    private String name;
    
    @Column(name = "adress", nullable=false)
    private String adress;
    
    @Column(name = "zipCode", nullable=false)
    private Long zipCode;
    
    @Column(name = "city", nullable=false)
    private String city;
    
    @Column(name = "country", nullable=false)
    private String country;
    
    @Column(name = "orders")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<Order> orders;
    
    public Recipient(String name, String adress, Long zipCode, String city, String country, List<Order> orders) {
        this.name = name;
        this.adress = adress;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
        this.orders = orders;
    }
    
    public Recipient() {
    }
    
    public Recipient(RecipientPayload recipientPayload) {
        this.id = recipientPayload.getId();
        this.name = recipientPayload.getName();
        this.adress = recipientPayload.getAddress();
        this.zipCode = recipientPayload.getZipCode();
        this.city = recipientPayload.getCity();
        this.country = recipientPayload.getCountry();
        this.orders = recipientPayload
                .getOrders()
                .stream()
                .map(order -> new Order(order))
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
