package com.creepyy.countchecker.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConstipationException extends Exception {

  private int statusCode;

  private String errorResponse;

  private String errorMessage;

}
