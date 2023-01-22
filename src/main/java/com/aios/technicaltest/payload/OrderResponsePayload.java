package com.aios.technicaltest.payload;

import com.aios.technicaltest.model.Order;
import java.math.BigDecimal;
import java.util.Date;

public class OrderResponsePayload {
    
    private Long id;
    private Date deliveryDate;
    private Integer quantity;
    private BigDecimal price;

    
    public OrderResponsePayload() {
    }
    
    public OrderResponsePayload(Long id, Date deliveryDate, Integer quantity, BigDecimal price) {
        this.id = id;
        this.deliveryDate = deliveryDate;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderResponsePayload(Order order) {
        this.id = order.getId();
        this.deliveryDate = order.getDeliveryDate();
        this.quantity = order.getQuantity();
        this.price = order.getPrice();
    }
    
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
