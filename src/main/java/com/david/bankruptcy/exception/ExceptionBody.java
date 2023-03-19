package com.david.bankruptcy.exception;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonInclude(Include.NON_NULL)
public class ExceptionBody {

  private Integer status;

  private LocalDateTime timestamp;

  private String message;

  private List<ExceptionField> fields;

}
