package com.nickolas.RochaProducoes.services;

import com.nickolas.RochaProducoes.models.Costumer;
import com.nickolas.RochaProducoes.repositories.CostumerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostumerService {

    private final CostumerRepository costumerRepository;

    CostumerService(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    public Costumer createCostumer(Costumer costumer) {
        return costumerRepository.save(costumer);
    }

    public Costumer getCostumerByEmail(String email) {
        Costumer costumer = this.costumerRepository.getCostumerByCostumerEmail(email);
        return costumer;
    }

    public List<Costumer> getAllCostumers() {
        return this.costumerRepository.findAll();
    }

    public Costumer updateCostumer(Costumer costumer) {
        if (this.costumerRepository.existsByCostumerEmail(costumer.getCostumerEmail())){
            return this.costumerRepository.save(costumer);
        }
        return null;
    }

    public void deleteCostumerByEmail(String email) {
        Costumer costumer = getCostumerByEmail(email);
        this.costumerRepository.delete(costumer);
    }
}
