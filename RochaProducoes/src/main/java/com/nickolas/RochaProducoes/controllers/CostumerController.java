package com.nickolas.RochaProducoes.controllers;

import com.nickolas.RochaProducoes.models.Costumer;
import com.nickolas.RochaProducoes.services.CostumerService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/costumer/")
public class CostumerController {

    private final CostumerService costumerService;

    public CostumerController(final CostumerService costumerService) {
        this.costumerService = costumerService;
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Costumer createCostumer(@RequestBody Costumer costumer) {
        costumerService.createCostumer(costumer);
        return costumer;
    }



}
