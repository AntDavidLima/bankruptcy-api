package com.david.bankruptcy.domain.income;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Entity
public class Income {

  @Id
  private Long id;

  private String description;

  private BigDecimal value;

}
