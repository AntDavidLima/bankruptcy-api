package com.david.bankruptcy.domain.income;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/incomes")
public class IncomeController {

  @GetMapping
  public List<Income> index() {
    return Arrays.asList(
        Income.builder()
            .id(UUID.randomUUID())
            .description("Salário")
            .value(BigDecimal.valueOf(6000.00))
            .build());
  }

}
