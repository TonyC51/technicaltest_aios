package com.aios.technicaltest.controller;

import com.aios.technicaltest.payload.OrderRequestPayload;
import com.aios.technicaltest.payload.OrderResponsePayload;
import com.aios.technicaltest.service.OrderService;
import com.aios.technicaltest.utils.ApiUrl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiUrl.ORDER)
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @PostMapping(ApiUrl.BY_ID)
    public OrderResponsePayload createOrder(@PathVariable Long id, @RequestBody OrderRequestPayload payload) {
        return orderService.createOrder(payload, id);
    }
    
    @PutMapping("")
    public OrderResponsePayload updateOrder(@RequestBody OrderRequestPayload recipient) {
        return orderService.updateOrder(recipient);
    }
    
    @GetMapping(ApiUrl.BY_ID)
    public OrderResponsePayload getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
    
    @GetMapping("")
    public List<OrderResponsePayload> getAllOrders() {
        return orderService.getAllOrders();
    }
    
    @DeleteMapping(ApiUrl.BY_ID)
    public boolean deleteOrderById(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }
    
}
