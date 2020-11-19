package com.gregorczyk.inventory.models;

import static java.util.Optional.ofNullable;

import java.util.Optional;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(fluent = true, chain = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
public class InventoryItem extends TrackedModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;
  private String description;
  private String imagePath;

  public Optional<String> description() {
    return ofNullable(description);
  }

  public InventoryItem description(Optional<String> description) {
    description.ifPresent(this::description);
    return this;
  }

  public InventoryItem description(String description) {
    this.description = description;
    return this;
  }

  public Optional<String> imagePath() {
    return ofNullable(imagePath);
  }
}
