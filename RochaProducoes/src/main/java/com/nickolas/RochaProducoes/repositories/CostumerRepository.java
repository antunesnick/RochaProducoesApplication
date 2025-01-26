package com.nickolas.RochaProducoes.repositories;

import com.nickolas.RochaProducoes.models.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CostumerRepository extends JpaRepository<Costumer, UUID> {
    Costumer getCostumerByCostumerEmail(String costumerEmail);

    boolean existsByCostumerEmail(String costumerEmail);
}
