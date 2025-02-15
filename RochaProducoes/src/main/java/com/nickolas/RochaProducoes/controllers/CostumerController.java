package com.nickolas.RochaProducoes.controllers;

import com.nickolas.RochaProducoes.models.Costumer;
import com.nickolas.RochaProducoes.services.CostumerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/costumer/")
public class CostumerController {

    private final CostumerService costumerService;

    public CostumerController(final CostumerService costumerService) {
        this.costumerService = costumerService;
    }


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Costumer createCostumer(@RequestBody  @Valid Costumer costumer) {
        costumerService.createCostumer(costumer);
        return costumer;
    }

    @GetMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Costumer findCostumerById(@PathVariable("email") String email) {
       return costumerService.getCostumerByEmail(email);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Costumer> findAllCostumers() {
        return costumerService.getAllCostumers();
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Costumer updateCostumer(@RequestBody @Valid Costumer costumer) {
       return costumerService.updateCostumer(costumer);
    }

    @DeleteMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCostumerById(@PathVariable("email") String email) {
        costumerService.deleteCostumerByEmail(email);
    }


}
