package com.aios.technicaltest.controller;

import com.aios.technicaltest.model.Recipient;
import com.aios.technicaltest.payload.RecipientPayload;
import com.aios.technicaltest.service.RecipientService;
import com.aios.technicaltest.utils.ApiUrl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiUrl.RECIPIENT)
public class RecipientController {
    
    @Autowired
    private RecipientService recipientService;
    
    @PostMapping("")
    public Recipient createRecipient(@RequestBody RecipientPayload recipient) {
        return recipientService.createRecipient(recipient);
    }
    
    @PutMapping("")
    public Recipient updateRecipient(@RequestBody RecipientPayload recipient) {
        return recipientService.updateRecipient(recipient);
    }
    
    @GetMapping(ApiUrl.BY_ID)
    public Recipient getRecipientById(@PathVariable Long id) {
        return recipientService.getRecipientById(id);
    }
    
    @GetMapping("")
    public List<Recipient> getAllRecipients() {
        return recipientService.getAllRecipients();
    }
    
    @DeleteMapping(ApiUrl.BY_ID)
    public boolean deleteRecipientById(@PathVariable Long id) {
        return recipientService.deleteRecipient(id);
    }
    
}