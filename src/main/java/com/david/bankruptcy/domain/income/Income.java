package com.david.bankruptcy.domain.income;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.david.bankruptcy.common.ValidationGroups;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Income {

  @Id
  @GeneratedValue
  private UUID id;

  @NotBlank(groups = ValidationGroups.Create.class)
  @Size(min = 1)
  private String description;

  @NotNull(groups = ValidationGroups.Create.class)
  private BigDecimal value;

  @CreationTimestamp
  private ZonedDateTime createdAt;

  @UpdateTimestamp
  private ZonedDateTime updatedAt;

}
