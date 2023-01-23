package com.aios.technicaltest.service;

import com.aios.technicaltest.model.Order;
import com.aios.technicaltest.model.Recipient;
import com.aios.technicaltest.payload.OrderPayload;
import com.aios.technicaltest.repository.OrderRepository;
import com.aios.technicaltest.repository.RecipientRepository;
import com.aios.technicaltest.utils.Utils;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private RecipientRepository recipientRepository;
    
    @Autowired
    private Utils utils;

    @Override
    public OrderPayload createOrder(OrderPayload payload, Long recipientId) {
        return checkConditionLinkModelAndPersist(payload, recipientId);
    }

    @Override
    public OrderPayload updateOrder(OrderPayload payload, Long recipientId) {
        return checkConditionLinkModelAndPersist(payload, recipientId);
    }

    @Override
    public boolean deleteOrder(Long id) {
        try {
            orderRepository.deleteById(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            logger.error("An error occured during deletion of order number {}", id.toString(), e.getLocalizedMessage());
            return Boolean.FALSE;
        }
    }
    
    @Override
    public List<OrderPayload> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(o -> (new OrderPayload(o))).collect(Collectors.toList());
    }

    @Override
    public OrderPayload getOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            return new OrderPayload(order.get());
        } return null;
    }
    
    private Order mapDtoToDbo (OrderPayload payload) {
        Order result;
        try {
            result = new Order(payload);
            return result;
        } catch (Exception e) {
            logger.error("An exception occured during Order payload matching", e.getLocalizedMessage());
            return null;
        }
    }
    
    @Override
    public OrderPayload mapDboToDto (Order order) {
        OrderPayload result;
        try {
            result = new OrderPayload(order);
            return result;
        } catch (Exception e) {
            logger.error("An exception occured during Order payload matching", e.getLocalizedMessage());
            return null;
        }
    }
    
    private OrderPayload checkConditionLinkModelAndPersist (OrderPayload payload, Long recipientId) {
        
        // handle condition checking for business
        utils.checkBusinessConditions(payload);

        // map from API to base 
        Order order = mapDtoToDbo(payload);
        
        if (order != null) {
            
            // apply price
            utils.applyPrice(order);
            
            Optional<Recipient> recipient = recipientRepository.findById(recipientId);
            
            if (recipient.isPresent()) {
                recipient.get().getOrders().add(order);
                order.setRecipientId(recipientId);
                order.setRecipient(recipient.get());
                recipientRepository.save(recipient.get());
                return mapDboToDto(order);
            }
        } return null;
    
}
}
