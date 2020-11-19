package com.gregorczyk.inventory.controllers;

import static java.util.stream.Collectors.toUnmodifiableList;

import com.gregorczyk.inventory.dto.CreateInventoryItemRequest;
import com.gregorczyk.inventory.dto.InventoryItemResponse;
import com.gregorczyk.inventory.dto.UpdateInventoryItemRequest;
import com.gregorczyk.inventory.exceptions.NotFoundException;
import com.gregorczyk.inventory.models.InventoryItem;
import com.gregorczyk.inventory.repositories.InventoryItemRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryItemController {

  private final InventoryItemRepo inventoryItemRepo;

  @Autowired
  public InventoryItemController(InventoryItemRepo inventoryItemRepo) {
    this.inventoryItemRepo = inventoryItemRepo;
  }

  private static InventoryItemResponse toDto(InventoryItem inventoryItem) {
    return new InventoryItemResponse()
        .id(inventoryItem.id())
        .name(inventoryItem.name())
        .description(inventoryItem.description())
        .imagePath(inventoryItem.imagePath())
        .createdDate(inventoryItem.createdDate())
        .updatedDate(inventoryItem.updatedDate());
  }

  @GetMapping
  public List<InventoryItemResponse> getInventoryItems() {
    return inventoryItemRepo.findAll().stream()
        .map(InventoryItemController::toDto)
        .collect(toUnmodifiableList());
  }

  @PostMapping
  public InventoryItemResponse createInventoryItem(
      @RequestBody CreateInventoryItemRequest request) {
    final var inventoryItem =
        inventoryItemRepo.save(
            new InventoryItem().name(request.name()).description(request.description()));
    return toDto(inventoryItem);
  }

  @GetMapping("/{id}")
  public InventoryItemResponse getInventoryItem(@PathVariable("id") long id) {
    return inventoryItemRepo
        .findById(id)
        .map(InventoryItemController::toDto)
        .orElseThrow(() -> new NotFoundException(id));
  }

  @PutMapping("/{id}")
  public InventoryItemResponse updateInventoryItem(
      @PathVariable("id") long id, @RequestBody UpdateInventoryItemRequest request) {
    final var inventoryItem = inventoryItemRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    request.name().ifPresent(inventoryItem::name);
    request.description().ifPresent(inventoryItem::description);
    return toDto(inventoryItemRepo.save(inventoryItem));
  }
}
