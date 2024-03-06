package com.example.crud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ErrorResponse {
    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;
}
