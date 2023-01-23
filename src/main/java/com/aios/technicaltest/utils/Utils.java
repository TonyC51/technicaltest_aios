package com.aios.technicaltest.utils;

import com.aios.technicaltest.exceptions.CustomException;
import com.aios.technicaltest.exceptions.ExceptionType;
import com.aios.technicaltest.model.Order;
import com.aios.technicaltest.payload.OrderPayload;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZonedDateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Utils {
    
    @Value("${banana.kg.price}")
    private double kgPrice;
    
    public boolean checkBusinessConditions (OrderPayload order) {
        return checkDate(order) == true &&
                checkMultiple(order) == true &&
                checkQuantity(order) == true;
        
    }
    
    public boolean checkDate (OrderPayload payload) {
        // check for dates
        Instant askedDate = payload.getDeliveryDate().toInstant();
        Instant oneWeekLater = ZonedDateTime.now().plusWeeks(1).toInstant();
       
        if (oneWeekLater.isAfter(askedDate)) {
            throw new CustomException(ExceptionType.DATE_SHOULD_BE_IN_ATLEAST_ONE_WEEK);
        }
        return true;
    }
    
    public boolean checkQuantity (OrderPayload payload) {
        // check for quantity
        if (payload.getQuantity() < 0 || payload.getQuantity() > 10000) {
            throw new CustomException(ExceptionType.QUANTITY_SHOUD_BE_BETWEEN_0_AND_10000);
        }
        return true;
    }
    
    public boolean checkMultiple (OrderPayload payload) {
        // check for 25 multiple
        if (payload.getQuantity() % 25 != 0) {
            throw new CustomException(ExceptionType.QUANTITY_SHOULD_BE_MULTIPLE_OF_25);
        }
        return true;
    }    
    
    public void applyPrice (Order order) {
        // calculate price
        order.setPrice(new BigDecimal(order.getQuantity().doubleValue() * kgPrice));
    }
                        
}
