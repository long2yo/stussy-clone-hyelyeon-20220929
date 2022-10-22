package com.stussy.stussyclonehyelyeon20220929.handler;

import com.stussy.stussyclonehyelyeon20220929.dto.CMRespDto;
import com.stussy.stussyclonehyelyeon20220929.exception.CustomValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RestControllerAdvice

public class RestControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<?> validationErrorException(CustomValidationException e){
        return ResponseEntity
                .badRequest()
                .body(new CMRespDto<>(1, e.getMessage(), e.getErrorMap()));
    }
}