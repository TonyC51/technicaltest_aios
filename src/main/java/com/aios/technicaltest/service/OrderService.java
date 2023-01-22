package com.aios.technicaltest.service;

import com.aios.technicaltest.payload.OrderRequestPayload;
import com.aios.technicaltest.payload.OrderResponsePayload;
import java.util.List;

public interface OrderService {
    
    public OrderResponsePayload createOrder(OrderRequestPayload order, Long recipientId);
    
    public OrderResponsePayload updateOrder(OrderRequestPayload order);
    
    public boolean deleteOrder(Long id);

    public List<OrderResponsePayload> getAllOrders();

    public OrderResponsePayload getOrderById(Long id);
    
}
