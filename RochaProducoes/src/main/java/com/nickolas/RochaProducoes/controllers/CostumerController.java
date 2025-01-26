package com.nickolas.RochaProducoes.controllers;

import com.nickolas.RochaProducoes.models.Costumer;
import com.nickolas.RochaProducoes.services.CostumerService;
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


    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Costumer createCostumer(@RequestBody Costumer costumer) {
        costumerService.createCostumer(costumer);
        return costumer;
    }

    @GetMapping("findbyemail")
    @ResponseStatus(HttpStatus.OK)
    public Costumer findCostumerById(@RequestParam("email") String email) {
       return costumerService.getCostumerByEmail(email);
    }

    @GetMapping("findall")
    @ResponseStatus(HttpStatus.OK)
    public List<Costumer> findAllCostumers() {
        return costumerService.getAllCostumers();
    }

    @PutMapping("create")
    @ResponseStatus(HttpStatus.OK)
    public Costumer updateCostumer(@RequestBody Costumer costumer) {
       return costumerService.updateCostumer(costumer);
    }

    @DeleteMapping("deletebyemail")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCostumerById(@RequestParam("email") String email) {
        costumerService.deleteCostumerByEmail(email);
    }


}
