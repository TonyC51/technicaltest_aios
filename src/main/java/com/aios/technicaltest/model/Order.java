package com.aios.technicaltest.model;

import com.aios.technicaltest.payload.OrderPayload;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

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
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Recipient.class)
    private Recipient recipient;
    
    @Transient
    @JoinColumn(name = "recipientId", referencedColumnName = "id")
    private Long recipientId;

    public Order(Date deliveryDate, Integer quantity, BigDecimal price, Long recipientId) {
        this.deliveryDate = deliveryDate;
        this.quantity = quantity;
        this.price = price;
        this.recipientId = recipientId;
    }
    
    public Order(OrderPayload orderPayload) {
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
    
    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }
}
