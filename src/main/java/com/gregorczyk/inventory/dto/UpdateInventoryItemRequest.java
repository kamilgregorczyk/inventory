package com.gregorczyk.inventory.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class UpdateInventoryItemRequest {
  @JsonProperty("name")
  private Optional<String> name = Optional.empty();

  @JsonProperty("description")
  private Optional<String> description = Optional.empty();
}
