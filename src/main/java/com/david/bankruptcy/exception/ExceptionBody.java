package com.david.bankruptcy.exception;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ExceptionBody {

  private Integer status;

  private LocalDateTime timestamp;

  private String message;

  private List<ExceptionField> fields;

}
