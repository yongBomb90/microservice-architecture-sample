package com.example.oauthservice.module.common.domain;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

//TODO ResponseEntity override
public class ResultDTO extends ResponseEntity {

    public ResultDTO(HttpStatus status) {
        super(status);
    }

    public ResultDTO(Object body, HttpStatus status) {
        super(body, status);
    }

    public ResultDTO(MultiValueMap headers, HttpStatus status) {
        super(headers, status);
    }

    public ResultDTO(Object body, MultiValueMap headers, HttpStatus status) {
        super(body, headers, status);
    }

    public ResultDTO(Object body, MultiValueMap headers, int rawStatus) {
        super(body, headers, rawStatus);
    }
}
