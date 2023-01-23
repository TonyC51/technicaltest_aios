package com.aios.technicaltest.service;

import com.aios.technicaltest.exceptions.CustomException;
import com.aios.technicaltest.exceptions.ExceptionType;
import com.aios.technicaltest.model.Recipient;
import com.aios.technicaltest.payload.RecipientPayload;
import com.aios.technicaltest.repository.RecipientRepository;
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

    @Override
    public Recipient createRecipient(RecipientPayload payload) {
        if (recipientRepository.existsByName(payload.getName())) {
            throw new CustomException(ExceptionType.RECIPIENT_ALREADY_EXISTS);
        }
        Recipient recipient = mapDtoToDbo(payload);
        if (recipient != null) {
            return recipientRepository.save(mapDtoToDbo(payload));
        } return null;
    }

    @Override
    public Recipient updateRecipient(RecipientPayload payload) {
        Recipient recipient = mapDtoToDbo(payload);
        if (recipient != null) {
            return recipientRepository.save(recipient);
        } return null;
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
    public List<Recipient> getAllRecipients() {
        return recipientRepository.findAll();
    }
    
    @Override
    public Recipient getRecipientById(Long id) {
        Optional<Recipient> recipient = recipientRepository.findById(id);
        return recipient.orElse(null);
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
    
}
