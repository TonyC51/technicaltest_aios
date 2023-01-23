package com.aios.technicaltest.service;

import com.aios.technicaltest.model.Recipient;
import com.aios.technicaltest.payload.RecipientPayload;
import java.util.List;

public interface RecipientService {
    
    public Recipient createRecipient (RecipientPayload recipient);
    
    public Recipient updateRecipient (RecipientPayload recipient);
    
    public boolean deleteRecipient(Long id);
    
    public List<Recipient> getAllRecipients();
    
    public Recipient getRecipientById(Long id);
    
    public Recipient mapDtoToDbo (RecipientPayload payload);
    
}
