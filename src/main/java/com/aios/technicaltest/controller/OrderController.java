package com.aios.technicaltest.controller;

import com.aios.technicaltest.model.Order;
import com.aios.technicaltest.payload.OrderPayload;
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
    public OrderPayload createOrder(@PathVariable Long id, @RequestBody OrderPayload payload) {
        return orderService.createOrder(payload, id);
    }
    
    @PutMapping("")
    public OrderPayload updateOrder(@RequestBody OrderPayload recipient) {
        return orderService.updateOrder(recipient);
    }
    
    @GetMapping(ApiUrl.BY_ID)
    public OrderPayload getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
    
    @GetMapping("")
    public List<OrderPayload> getAllOrders() {
        return orderService.getAllOrders();
    }
    
    @DeleteMapping(ApiUrl.BY_ID)
    public boolean deleteOrderById(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }
    
}
