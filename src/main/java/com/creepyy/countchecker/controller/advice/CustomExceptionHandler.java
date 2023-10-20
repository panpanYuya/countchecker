package com.creepyy.countchecker.controller.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.creepyy.countchecker.Exception.BadRequestException;
import com.creepyy.countchecker.common.constants.ErrorConst;
import com.creepyy.countchecker.model.response.ResponseError;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ BadRequestException.class })
    public @ResponseBody ResponseEntity<Object> handlerInternalServerError(BadRequestException e,
            WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        Map<String, String> errorBody = new HashMap<>();
        errorBody.put("message", ErrorConst.INTERNAL_SERVER_ERROR_MESSAGE);
        ObjectMapper objectMapper = new ObjectMapper();
        String errorResponse = "";
        try {
            // エラーメッセージ用のjsonのためにtry catchを配置
            errorResponse = objectMapper.writeValueAsString(errorBody);
        } catch (JsonProcessingException e1) {
            e.printStackTrace();
            errorResponse = ErrorConst.INTERNAL_SERVER_ERROR_MESSAGE;
        }
        return handleExceptionInternal(e, errorResponse, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
