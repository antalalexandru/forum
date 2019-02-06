package com.crg.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ApiErrorResponse {
    private String timestamp;
    private Integer status;
    private String error;
    private String message;
}
