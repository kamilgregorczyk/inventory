package com.gregorczyk.inventory.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.util.Optional;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Accessors(fluent = true, chain = true)
@NoArgsConstructor
public class InventoryItemResponse {
  @JsonProperty("id")
  private long id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private Optional<String> description;

  @JsonProperty("imagePath")
  private Optional<String> imagePath;

  @JsonProperty("createdDate")
  private Instant createdDate;

  @JsonProperty("updatedDate")
  private Instant updatedDate;
}
