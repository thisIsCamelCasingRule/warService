package com.example.warService.service;

import com.example.warService.model.Kingdom;
import org.springframework.data.repository.CrudRepository;


public interface KingdomRepo extends CrudRepository<Kingdom, Integer> {
    Kingdom getKingdomByName(String name);
}
