package com.nickolas.RochaProducoes.services;

import com.nickolas.RochaProducoes.models.Costumer;
import com.nickolas.RochaProducoes.repositories.CostumerRepository;
import org.springframework.stereotype.Service;

@Service
public class CostumerService {

    private final CostumerRepository costumerRepository;

    CostumerService(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    public Costumer createCostumer(Costumer costumer) {
        return costumerRepository.save(costumer);
    }

}
