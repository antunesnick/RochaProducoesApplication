package com.nickolas.RochaProducoes.services;

import com.nickolas.RochaProducoes.models.Costumer;
import com.nickolas.RochaProducoes.repositories.CostumerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriBuilder;


@Service
public class CostumerService {

    private final CostumerRepository costumerRepository;

    public CostumerService(final CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }


    public void createCostumer(Costumer costumer) {
        costumerRepository.save(costumer);
    }



}
