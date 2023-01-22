package com.aios.technicaltest.payload;

import com.aios.technicaltest.model.Order;
import java.util.Date;

public class OrderRequestPayload {
    
    private Long id;
    private Date deliveryDate;
    private Integer quantity;
    
    public OrderRequestPayload() {
    }
    
    public OrderRequestPayload(Long id, Date deliveryDate, Integer quantity) {
        this.id = id;
        this.deliveryDate = deliveryDate;
        this.quantity = quantity;
    }

    public OrderRequestPayload(Order order) {
        this.id = order.getId();
        this.deliveryDate = order.getDeliveryDate();
        this.quantity = order.getQuantity();
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
