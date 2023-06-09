package com.david.bankruptcy.domain.income;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.david.bankruptcy.common.ValidationGroups;
import com.david.bankruptcy.util.NullAwareBeanUtilsBean;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/incomes")
@AllArgsConstructor
public class IncomeController {

  private IncomeRepository incomeRepository;

  private NullAwareBeanUtilsBean<Income> beanUtilsBean;

  @GetMapping
  public List<Income> index() {
    return incomeRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Income> show(@PathVariable UUID id) {
    return incomeRepository.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Income create(@Validated(ValidationGroups.Create.class) @RequestBody Income body) {
    return incomeRepository.save(body);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Income> update(@Validated @RequestBody Income body, @PathVariable UUID id) {
    return incomeRepository.findById(id)
        .map(income -> {

          beanUtilsBean.copyProperties(body, income);

          Income updatedIncome = incomeRepository.save(income);

          return ResponseEntity.ok(updatedIncome);
        })
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> destroy(@PathVariable UUID id) {
    if (!incomeRepository.existsById(id)) {
      return ResponseEntity.notFound().build();
    }

    incomeRepository.deleteById(id);

    return ResponseEntity.noContent().build();
  }

}
