package com.aios.technicaltest.payload;

import com.aios.technicaltest.model.Order;
import java.math.BigDecimal;
import java.util.Date;

public class OrderPayload {
    
    private Long id;
    private Date deliveryDate;
    private Integer quantity;
    private BigDecimal price;
    private Long recipientId;
    
    public OrderPayload() {
    }
    
    public OrderPayload(Long id, Date deliveryDate, Integer quantity, BigDecimal price, Long recipientId) {
        this.id = id;
        this.deliveryDate = deliveryDate;
        this.quantity = quantity;
        this.price = price;
        this.recipientId = recipientId;
    }
    
    public OrderPayload(Long id, Date deliveryDate, Integer quantity, Long recipientId) {
        this.id = id;
        this.deliveryDate = deliveryDate;
        this.quantity = quantity;
        this.price = price;
        this.recipientId = recipientId;
    }

    public OrderPayload(Order order) {
        this.id = order.getId();
        this.deliveryDate = order.getDeliveryDate();
        this.quantity = order.getQuantity();
        this.price = order.getPrice();
        this.recipientId = order.getRecipientId();
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
    
    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }
}
