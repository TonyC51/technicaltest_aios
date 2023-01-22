package com.aios.technicaltest.model;

import com.aios.technicaltest.payload.OrderRequestPayload;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "banana_order")
public class Order implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "delivery_date", nullable=false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date deliveryDate;
    
    @Column(name = "quantity", nullable=false)
    private Integer quantity;
    
    @Column(name = "price")
    private BigDecimal price;

    public Order(Date deliveryDate, Integer quantity, BigDecimal price) {
        this.deliveryDate = deliveryDate;
        this.quantity = quantity;
        this.price = price;
    }
    
    public Order(OrderRequestPayload orderPayload) {
        this.id = orderPayload.getId();
        this.deliveryDate = orderPayload.getDeliveryDate();
        this.quantity = orderPayload.getQuantity();
    }
    
    public Order() {
    }

    public Long getId() {
        return id;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
