package com.aios.technicaltest.service;

import com.aios.technicaltest.model.Recipient;
import com.aios.technicaltest.payload.RecipientPayload;
import java.util.List;

public interface RecipientService {
    
    public RecipientPayload createRecipient (RecipientPayload recipient);
    
    public RecipientPayload updateRecipient (RecipientPayload recipient);
    
    public boolean deleteRecipient(Long id);
    
    public List<RecipientPayload> getAllRecipients();
    
    public RecipientPayload getRecipientById(Long id);
    
    public Recipient mapDtoToDbo (RecipientPayload payload);
    
    public RecipientPayload mapDboToDto (Recipient recipient);
    
    public List<RecipientPayload> mapDboListToDtoList (List<Recipient> recipients);

    
}
