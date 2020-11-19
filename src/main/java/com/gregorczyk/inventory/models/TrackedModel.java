package com.gregorczyk.inventory.models;

import java.time.Instant;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Accessors(fluent = true, chain = true)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class TrackedModel {
  @CreatedDate private Instant createdDate;

  @LastModifiedDate private Instant updatedDate;
}
