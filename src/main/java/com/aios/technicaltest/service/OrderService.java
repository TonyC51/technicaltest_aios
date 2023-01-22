package com.aios.technicaltest.service;

import com.aios.technicaltest.payload.OrderPayload;
import java.util.List;

public interface OrderService {
    
    public OrderPayload createOrder(OrderPayload order, Long recipientId);
    
    public OrderPayload updateOrder(OrderPayload order);
    
    public boolean deleteOrder(Long id);

    public List<OrderPayload> getAllOrders();

    public OrderPayload getOrderById(Long id);
    
}
