package com.creepyy.countchecker.Exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class BadRequestException extends Exception {
    private String errorMessage;
}
