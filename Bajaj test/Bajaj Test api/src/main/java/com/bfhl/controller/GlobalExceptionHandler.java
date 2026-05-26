package com.bfhl.controller;

import com.bfhl.dto.BfhlResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BfhlResponse> handle(Exception e) {
        BfhlResponse r = new BfhlResponse();
        r.setSuccess(false);
        r.setUserId("shuddhakaushik_27092005");
        r.setEmail("shuddhakaushik230666@acropolis.in");
        r.setRollNumber("0827CY231069");
        r.setOddNumbers(Collections.emptyList());
        r.setEvenNumbers(Collections.emptyList());
        r.setAlphabets(Collections.emptyList());
        r.setSpecialCharacters(Collections.emptyList());
        r.setSum("0");
        r.setConcatString("");
        return ResponseEntity.ok(r);
    }
}
