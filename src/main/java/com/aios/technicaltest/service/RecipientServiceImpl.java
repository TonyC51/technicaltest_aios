package com.aios.technicaltest.service;

import com.aios.technicaltest.exceptions.CustomException;
import com.aios.technicaltest.exceptions.ExceptionType;
import com.aios.technicaltest.model.Recipient;
import com.aios.technicaltest.payload.OrderPayload;
import com.aios.technicaltest.payload.RecipientPayload;
import com.aios.technicaltest.repository.RecipientRepository;
import com.aios.technicaltest.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipientServiceImpl implements RecipientService {
    
    private static final Logger logger = LoggerFactory.getLogger(RecipientServiceImpl.class);
    
    @Autowired
    private RecipientRepository recipientRepository;
    
    @Autowired
    private Utils utils;

    @Override
    public RecipientPayload createRecipient(RecipientPayload payload) {
        if (recipientRepository.existsByName(payload.getName())) {
            throw new CustomException(ExceptionType.RECIPIENT_ALREADY_EXISTS);
        }    
        return checkConditionsLinkModelsAndPersist(payload);
    }

    @Override
    public RecipientPayload updateRecipient(RecipientPayload payload) {
        return checkConditionsLinkModelsAndPersist(payload);
    }

    @Override
    public boolean deleteRecipient(Long id) {
        try {
            recipientRepository.deleteById(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            logger.error("An error occured during deletion of recipient number {}", id.toString(), e.getLocalizedMessage());
            return Boolean.FALSE;
        }
    }

    @Override
    public List<RecipientPayload> getAllRecipients() {
        return mapDboListToDtoList(recipientRepository.findAll());
    }
    
    @Override
    public RecipientPayload getRecipientById(Long id) {
        Optional<Recipient> recipient = recipientRepository.findById(id);
        if (recipient.isPresent()) {
            return mapDboToDto(recipient.get());
        }
        throw new CustomException(ExceptionType.RECIPIENT_NOT_EXIST);
    }
    
    @Override
    public Recipient mapDtoToDbo (RecipientPayload payload) {
        Recipient result;
        try {
            result = new Recipient(payload);
            return result;
        } catch (Exception e) {
            logger.error("An exception occured during Recipient payload matching", e.getLocalizedMessage());
            return null;
        }   
    }
    
    @Override
    public List<RecipientPayload> mapDboListToDtoList (List<Recipient> recipients) {
        
        if (recipients == null) {
            return null;
            //needs custom exception
        }
        
        List<RecipientPayload> dtos = new ArrayList<>();
        for (Recipient recip : recipients) {
            dtos.add(mapDboToDto(recip));
        }
        return dtos;
    }
    
    @Override
    public RecipientPayload mapDboToDto (Recipient recipient) {
        RecipientPayload result;
        try {
            result = new RecipientPayload(recipient);
            return result;
        } catch (Exception e) {
            logger.error("An exception occured during Order payload matching", e.getLocalizedMessage());
            return null;
        }
    } 
    
    private RecipientPayload checkConditionsLinkModelsAndPersist (RecipientPayload payload) {
        
        // handle business condition checking
        for (OrderPayload order : payload.getOrders()) {
            utils.checkBusinessConditions(order);
        }
        
        Recipient recipient = mapDtoToDbo(payload);
        if (recipient != null) {
            recipient.getOrders().forEach(o -> o.setRecipient(recipient));
            recipient.getOrders().forEach(o -> utils.applyPrice(o));
            return mapDboToDto(recipientRepository.save(mapDtoToDbo(payload)));
        } return null;
    }
    
}
