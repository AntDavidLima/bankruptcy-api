package com.david.bankruptcy.exception;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ExceptionField {

  private String name;

  private String message;

}
