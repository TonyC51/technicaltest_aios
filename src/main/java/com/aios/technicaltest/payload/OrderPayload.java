package com.aios.technicaltest.payload;

import com.aios.technicaltest.model.Order;
import java.math.BigDecimal;
import java.util.Date;

public class OrderPayload {
    
    private Long id;
    //private RecipientPayload recipient;
    private Date deliveryDate;
    private Integer quantity;
    private BigDecimal price;
    
    public OrderPayload() {
    }
    
    public OrderPayload(Long id, Date deliveryDate, Integer quantity, BigDecimal price) {
        //this.recipient = recipient;
        this.id = id;
        this.deliveryDate = deliveryDate;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderPayload(Order order) {
        this.id = order.getId();
        //this.recipient = new RecipientPayload(order.getRecipient());
        this.deliveryDate = order.getDeliveryDate();
        this.quantity = order.getQuantity();
        this.price = order.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public RecipientPayload getRecipient() {
//        return recipient;
//    }
//
//    public void setRecipient(RecipientPayload recipient) {
//        this.recipient = recipient;
//    }

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
