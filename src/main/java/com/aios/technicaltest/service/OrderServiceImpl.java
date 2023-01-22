package com.aios.technicaltest.service;

import com.aios.technicaltest.exceptions.CustomException;
import com.aios.technicaltest.exceptions.ExceptionType;
import com.aios.technicaltest.model.Order;
import com.aios.technicaltest.model.Recipient;
import com.aios.technicaltest.payload.OrderRequestPayload;
import com.aios.technicaltest.payload.OrderResponsePayload;
import com.aios.technicaltest.repository.OrderRepository;
import com.aios.technicaltest.repository.RecipientRepository;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZonedDateTime;
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

    @Override
    public OrderResponsePayload createOrder(OrderRequestPayload payload, Long recipientId) {
        
        // check for quantity
        if (payload.getQuantity() < 0 || payload.getQuantity() > 10000) {
            throw new CustomException(ExceptionType.QUANTITY_SHOUD_BE_BETWEEN_0_AND_10000);
        }
        
        // check for 25 multiple
        if (payload.getQuantity() % 25 != 0) {
            throw new CustomException(ExceptionType.QUANTITY_SHOULD_BE_MULTIPLE_OF_25);
        }
        
        // check for dates
        Instant askedDate = payload.getDeliveryDate().toInstant();
        Instant oneWeekLater = ZonedDateTime.now().plusWeeks(1).toInstant();
       
        if (oneWeekLater.isAfter(askedDate)) {
            throw new CustomException(ExceptionType.DATE_SHOULD_BE_IN_ATLEAST_ONE_WEEK);
        }

        // map from API to base 
        Order order = mapDtoToDbo(payload);
        
        if (order != null) {
            
            // calculate price
            order.setPrice(new BigDecimal(order.getQuantity().doubleValue() * 2.5));
            
            Optional<Recipient> recipient = recipientRepository.findById(recipientId);
            
            if (recipient.isPresent()) {
                recipient.get().getOrders().add(order);
                recipientRepository.save(recipient.get());
                return mapDboToDto(order);
            }
        } return null;
    }

    @Override
    public OrderResponsePayload updateOrder(OrderRequestPayload payload) {
        Order order = mapDtoToDbo(payload);
        if (order != null) {
            order = orderRepository.save(mapDtoToDbo(payload));
            return mapDboToDto(order); 
        } return null;
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
    public List<OrderResponsePayload> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(o -> (new OrderResponsePayload(o))).collect(Collectors.toList());
    }

    @Override
    public OrderResponsePayload getOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            return new OrderResponsePayload(order.get());
        } return null;
    }
    
    private Order mapDtoToDbo (OrderRequestPayload payload) {
        Order result;
        try {
            result = new Order(payload);
            return result;
        } catch (Exception e) {
            logger.error("An exception occured during Order payload matching", e.getLocalizedMessage());
            return null;
        }
    }
    
    private OrderResponsePayload mapDboToDto (Order order) {
        OrderResponsePayload result;
        try {
            result = new OrderResponsePayload(order);
            return result;
        } catch (Exception e) {
            logger.error("An exception occured during Order payload matching", e.getLocalizedMessage());
            return null;
        }
    } 
}
