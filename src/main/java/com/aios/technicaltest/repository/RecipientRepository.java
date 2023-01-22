package com.aios.technicaltest.repository;

import com.aios.technicaltest.model.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipientRepository extends JpaRepository<Recipient, Long> {

    public boolean existsByName(String name);
    
}
