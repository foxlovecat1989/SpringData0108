package com.spring.mvc.psi.repository;

import com.spring.mvc.psi.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
    
}
