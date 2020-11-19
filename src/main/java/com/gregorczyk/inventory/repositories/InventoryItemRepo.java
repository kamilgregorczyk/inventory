package com.gregorczyk.inventory.repositories;

import com.gregorczyk.inventory.models.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryItemRepo extends JpaRepository<InventoryItem, Long> {}
