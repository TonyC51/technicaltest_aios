package com.aios.technicaltest.service;

import com.aios.technicaltest.model.Order;
import com.aios.technicaltest.payload.OrderPayload;
import java.util.List;

public interface OrderService {
    
    public OrderPayload createOrder(OrderPayload order, Long recipientId);
    
    public OrderPayload updateOrder(OrderPayload payload, Long recipientId);
    
    public boolean deleteOrder(Long id);

    public List<OrderPayload> getAllOrders();

    public OrderPayload getOrderById(Long id);
    
    public OrderPayload mapDboToDto (Order order);
    
}
